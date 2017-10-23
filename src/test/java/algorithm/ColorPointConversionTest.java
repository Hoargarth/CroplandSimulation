package algorithm;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static algorithm.ColorPointConversion.MAX_VALUE;
import static algorithm.ColorPointConversion.MIN_VALUE;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

class ColorPointConversionTest {


    @Test
    void testsBlackAndWhitePixel() {
        final Point3D whitePoint = ColorPointConversion.convertColorToPoint(255);
        final Point3D blackPoint = ColorPointConversion.convertColorToPoint(0);

        assertEquals(new Point3D(0, 0, MAX_VALUE), whitePoint);
        assertEquals(new Point3D(0, 0, MIN_VALUE), blackPoint);

    }
}