package leetcode.medium;

/**
 * Created by chen on 1/1/18.
 */
public class Q50 {
    public static void main(String[] args) {
        new Q50Solution().myPow(1.0, Integer.MIN_VALUE);
    }
}

class Q50Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }

        int k = n / 2;
        int l = n - k * 2;
        double t1 = myPow(x, Math.abs(k));
        double t2 = myPow(x, Math.abs(l));
        if (isNegative) {
            return 1 / (t1 * t1 * t2);
        } else {
            return t1 * t1 * t2;
        }
    }
}