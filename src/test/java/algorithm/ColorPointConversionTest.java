package algorithm;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNotNull;

class ColorPointConversionTest {

    @Test
    void testsBlackPixelReturningZero() {
        assertNotNull(ColorPointConversion.convertColorToPoint());
    }
}