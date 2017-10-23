package algorithm;

import javafx.geometry.Point3D;

public class ColorPointConversion {

    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;

    static public Point3D convertColorToPoint(int i) {
        if (i >= 255) {
            return new Point3D(0, 0, MAX_VALUE);
        }
        return new Point3D(0, 0, MIN_VALUE);
    }
}
