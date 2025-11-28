package Complicated.Calculator;

public class AdvancedMath {
    private AdvancedMath() {
        // private constructor to prevent instantiation
    }

    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static double goldenSectionSearch(double a, double b, double tol) {
        // Golden-section search to find maximum of |f(x)| in [a, b]
        double phi = (1 + Math.sqrt(5)) / 2; // Golden ratio
        double resphi = 2 - phi;

        double c = b - resphi * (b - a);
        double d = a + resphi * (b - a);
        while (Math.abs(c - d) > tol) {
            if (Math.abs(Math.sin(c)) < Math.abs(Math.sin(d))) {
                b = d;
            } else {
                a = c;
            }
            c = b - resphi * (b - a);
            d = a + resphi * (b - a);
        }
        return (a + b) / 2;
    }
    
    private static double lagrangeError(double x, int n, double M) {
        // Calculate the error bound
        return M * Math.pow(Math.abs(x), n + 1) / factorial(n + 1);
    }

    public static double sin(double val) {
        double output = 0;
        for (int n = 0; n < 10; n++) {
            double term = Math.pow(-1, n) * Math.pow(val, 2 * n + 1) / factorial(2 * n + 1);
            output += term;
        }
        System.out.println("sin(" + val + ") approximated as: " + output);
        // Estimate the maximum value of the 11th derivative of sin(x) which is 1
        if (val > Math.PI / 2 || val < -Math.PI / 2) {
            Double M = 1.0; // since sin(x) and its derivatives are bounded by 1
            System.out.println("Estimated Lagrange error: " + lagrangeError(val, 10, M));
        }
        else{
            Double M = goldenSectionSearch(0, Math.abs(val), 0.0001);
            System.out.println("Estimated Lagrange error: " + lagrangeError(val, 10, M));
        }
        return output;
    }

    public static double cos(double val) {
        double output = 0;
        for (int n = 0; n < 10; n++) {
            double term = Math.pow(-1, n) * Math.pow(val, 2 * n) / factorial(2 * n);
            output += term; 
        }
        return output;
    }

    public static double tan(double val) {
        return Math.tan(val);
    }

    public static double log10(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Logarithm undefined for non-positive values.");
        }
        return Math.log10(value);
    }
    
}
