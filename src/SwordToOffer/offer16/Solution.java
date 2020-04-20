package SwordToOffer.offer16;

public class Solution {
    public double Power(double base, int exponent) {
        boolean flag = false;
        double res = 1;
        if (base == 0) {
            return 0;
        }
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }

        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        if (flag) {
            res = 1 / res;
        }
        return res;
    }
}
