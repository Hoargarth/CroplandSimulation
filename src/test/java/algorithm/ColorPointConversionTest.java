package algorithm;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Test;

import static algorithm.ColorPointConversion.MAX_VALUE;
import static algorithm.ColorPointConversion.MIN_VALUE;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

class ColorPointConversionTest {


    @Test
    void testsBlackAndWhitePixel() {
        final Point3D whitePoint = ColorPointConversion.convertColorToPoint(255);
        final Point3D blackPoint = ColorPointConversion.convertColorToPoint(0);

        assertEquals(new Point3D(0, 0, MAX_VALUE), whitePoint);
        assertEquals(new Point3D(0, 0, MIN_VALUE), blackPoint);

    }

    @Test
    void testsGeneralColorToHeightConversion() {
        final Point3D QuarterHeightPoint = ColorPointConversion.convertColorToPoint((int) (255 * 0.25));
        final Point3D HalfHeightPoint = ColorPointConversion.convertColorToPoint((int) (255 / 2));
        final Point3D ThreequarterHeightPoint = ColorPointConversion.convertColorToPoint((int) (255 * 0.75));


        assertTrue(isBetween(QuarterHeightPoint.getZ(), 24, 26));
        assertTrue(isBetween(HalfHeightPoint.getZ(), 49, 51));
        assertTrue(isBetween(ThreequarterHeightPoint.getZ(), 74, 76));
    }

    private boolean isBetween(double what, double min, double max) {
        return what >= min && what <= max;
    }
}