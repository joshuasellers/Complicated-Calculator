package Complicated.Calculator.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvancedMathTest {

    @Test
    public void testSinApproximation() {
        double result = AdvancedMath.sin(Math.PI / 6);
        assertEquals(0.5, result, 1e-3);
    }

    @Test
    public void testCosZero() {
        double result = AdvancedMath.cos(0);
        assertEquals(1.0, result, 1e-6);
    }

    @Test
    public void testLnOne() {
        double result = AdvancedMath.ln(1);
        assertEquals(0.0, result, 1e-9);
    }
}
