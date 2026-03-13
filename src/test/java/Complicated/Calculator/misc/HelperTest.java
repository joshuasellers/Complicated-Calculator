package Complicated.Calculator.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void testInfixToRpnBasic() {
        String rpn = Helper.infixToRpn(new String[]{"3", "+", "4", "*", "2"});
        assertEquals("3 4 2 * + ", rpn);
    }

    @Test
    public void testEvaluateRpnBasicExpression() {
        double result = Helper.evaluateRpn("3 + 4 * 2");
        assertEquals(11.0, result, 1e-9);
    }

    @Test
    public void testEvaluateRpnWithParentheses() {
        double result = Helper.evaluateRpn("( 1 + 2 ) * 3");
        assertEquals(9.0, result, 1e-9);
    }
}
