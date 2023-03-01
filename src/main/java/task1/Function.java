package task1;

import static java.lang.Math.PI;

public class Function {
    public static double arctg(double x) {
        if (Math.abs(x) > 1) {
            return Double.NaN;
        }
        double eps = 0.00001;
        double result = x;
        double previous = result;
        double current = PI / 2 + 1;
        int i = 1;
        while (Math.abs(current - previous) > eps) {
            previous = current;
            current = Math.pow(-1, i) / (2 * i + 1) * Math.pow(x, 2 * i + 1);
            result += current;
            i++;
        }
        return result;
    }
}
