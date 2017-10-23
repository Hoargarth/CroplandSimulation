import com.sun.javafx.geom.Matrix3f;
import geometry.Landscape;
import geometry.Triangle;
import javafx.geometry.Point3D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Simulation {

    public Simulation() {
    }

    // rendering based on http://blog.rogach.org/2015/08/how-to-create-your-own-simple-3d-render.html
    // only software based...
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);


        // panel to display render results
        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // rendering magic will happen here

                java.util.List<Triangle> tris = new ArrayList<Triangle>();

                tris.add(new Triangle(new Point3D(100, 100, 100),
                        new Point3D(-100, -100, 100),
                        new Point3D(-100, 100, -100),
                        Color.WHITE));
                tris.add(new Triangle(new Point3D(100, 100, 100),
                        new Point3D(-100, -100, 100),
                        new Point3D(100, -100, -100),
                        Color.RED));
                tris.add(new Triangle(new Point3D(-100, 100, -100),
                        new Point3D(100, -100, -100),
                        new Point3D(100, 100, 100),
                        Color.GREEN));
                tris.add(new Triangle(new Point3D(-100, 100, -100),
                        new Point3D(100, -100, -100),
                        new Point3D(-100, -100, 100),
                        Color.BLUE));

                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.WHITE);


                double heading = Math.toRadians(headingSlider.getValue());
               /* Matrix3f transform = new Matrix3f(new float[]{
                        (float) Math.cos(heading), 0, (float) -Math.sin(heading),
                        0, 1, 0,
                        (float) Math.sin(heading), 0, (float) Math.cos(heading)
                });
*/

                Matrix3f headingTransform = new Matrix3f(new float[] {
                        (float) Math.cos(heading), 0, (float) Math.sin(heading),
                        0, 1, 0,
                        (float) -Math.sin(heading), 0, (float) Math.cos(heading)
                });
                double pitch = Math.toRadians(pitchSlider.getValue());
                Matrix3f pitchTransform = new Matrix3f(new float[] {
                        1, 0, 0,
                        0, (float) Math.cos(pitch), (float) Math.sin(pitch),
                        0, (float) -Math.sin(pitch), (float) Math.cos(pitch)
                });

                Matrix3f transform = multiply(headingTransform, pitchTransform);

                Landscape landscape = new Landscape();

                landscape.render(transform, g2);

            }
        };

        headingSlider.addChangeListener(e -> renderPanel.repaint());
        pitchSlider.addChangeListener(e -> renderPanel.repaint());



        pane.add(renderPanel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    public static Matrix3f multiply(Matrix3f a, Matrix3f other) {
        Matrix3f result = new Matrix3f();

        result.m00 = a.m00 * other.m00 + a.m01 * other.m10 + a.m02 * other.m20;
        result.m10 = a.m10 * other.m00 + a.m11 * other.m10 + a.m12 * other.m20;
        result.m20 = a.m20 * other.m00 + a.m21 * other.m10 + a.m22 * other.m20;

        result.m01 = a.m00 * other.m01 + a.m01 * other.m11 + a.m02 * other.m21;
        result.m11 = a.m10 * other.m01 + a.m11 * other.m11 + a.m12 * other.m21;
        result.m21 = a.m20 * other.m01 + a.m21 * other.m11 + a.m22 * other.m21;

        result.m02 = a.m00 * other.m02 + a.m01 * other.m12 + a.m02 * other.m22;
        result.m12 = a.m10 * other.m02 + a.m11 * other.m12 + a.m12 * other.m22;
        result.m22 = a.m20 * other.m02 + a.m21 * other.m12 + a.m22 * other.m22;

        return result;
    }

    private static Point3D transform(Point3D v1, Matrix3f transform) {
        return new Point3D(
                v1.getX()* transform.m00 + v1.getY()*transform.m10 + v1.getZ()*transform.m20,
                v1.getX()* transform.m01 + v1.getY()*transform.m11 + v1.getZ()*transform.m21,
                v1.getX()* transform.m02 + v1.getY()*transform.m12 + v1.getZ()*transform.m22
        );
    }


    private static void runSimulation(String[] args) {

        String heightMap;

        while (ConsoleController.fileDialogReturn == 1) {

            //Prompt user for input
            System.out.println("You have to select a gray-scale height map with .png file format from your folder.\nPress ENTER to open your file browser:");

            /*
            * Todo: User needs to see the what to do, eg. press enter before filechooser pops up
            * */

            heightMap = ConsoleController.SelectGrayScaleHeightMap();

            System.out.println(heightMap);
        }
    }
}
