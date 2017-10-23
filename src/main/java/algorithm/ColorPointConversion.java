package algorithm;

import javafx.geometry.Point3D;

public class ColorPointConversion {

    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;

    static public Point3D convertColorToPoint(int i) {

        final int diff = MAX_VALUE - MIN_VALUE;

        final double result = i * MAX_VALUE / 255;

        return new Point3D(0, 0, MIN_VALUE + result);

    }
}
