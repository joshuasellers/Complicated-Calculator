package Complicated.Calculator;

public class AdvancedMath {
    private AdvancedMath() {
        // private constructor to prevent instantiation
    }

    public static double sin(double val) {
        return Math.sin(val);
    }

    public static double cos(double val) {
        return Math.cos(val);
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
