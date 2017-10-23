package geometry;

import com.sun.javafx.geom.Matrix3f;
import javafx.geometry.Point3D;

import java.awt.*;
import java.util.Random;
import java.awt.geom.Path2D;


public class Landscape {
    private Point3D points[][];

    public Landscape() {
        points = new Point3D[10][10];
        this.loadDefault();
    }

    private void loadDefault() {

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                points[i][j] = new Point3D(i * 50, j * 50, rand.nextFloat());
            }
        }
    }

    public void render(Matrix3f transformMatrix, Graphics2D g2) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                Path2D vPath = new Path2D.Double();

                final Point3D thisPoint = transform(points[i][j], transformMatrix);
                final Point3D nextPoint = transform(points[i][j + 1], transformMatrix);

                vPath.moveTo(thisPoint.getX(), thisPoint.getY());
                vPath.lineTo(nextPoint.getX(), nextPoint.getY());
                vPath.closePath();

                g2.draw(vPath);
            }

        }


        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                Path2D vPath = new Path2D.Double();

                final Point3D thisPoint = transform(points[i][j], transformMatrix);
                final Point3D nextPoint = transform(points[i + 1][j], transformMatrix);

                vPath.moveTo(thisPoint.getX(), thisPoint.getY());
                vPath.lineTo(nextPoint.getX(), nextPoint.getY());
                vPath.closePath();

                g2.draw(vPath);
            }

        }
    }

    private static Point3D transform(Point3D v1, Matrix3f transform) {
        return new Point3D(
                v1.getX() * transform.m00 + v1.getY() * transform.m10 + v1.getZ() * transform.m20,
                v1.getX() * transform.m01 + v1.getY() * transform.m11 + v1.getZ() * transform.m21,
                v1.getX() * transform.m02 + v1.getY() * transform.m12 + v1.getZ() * transform.m22
        );
    }
}
