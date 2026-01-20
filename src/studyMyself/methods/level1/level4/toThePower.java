package studyMyself.methods.level1.level4;

public class toThePower {
    public static void main(String[] args) {

        double power = pow(2, -3);
        System.out.println(power);

    }

    public static double pow(int base, int exponent) {
        int positiveExp = Math.abs(exponent);
        double result = 1.0;
        if (exponent == 0) {
            return 1;
        }

        for (int i = 0; i < positiveExp; i++) {
            result = result * base;
        }
        if (exponent < 0) {
            return 1.0 / result;
        }

        return result;

    }

}
