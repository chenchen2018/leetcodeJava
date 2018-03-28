package leetcode.medium;

/**
 * Created by chen on 12/28/17.
 */
public class Q29 {
}

class Q29Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long first = Math.abs((long)dividend);
        long second = Math.abs((long)divisor);
        long res = helper(first, second);
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sign * res);
    }

    private long helper(long first, long second) {
        if (first < second) {
            return 0;
        }
        long sum = second, count = 1;
        while (first >= sum + sum) {
            sum += sum;
            count += count;
        }
        return count + helper(first - sum, second);
    }

    //Do not use. Demo purpose only.
    private long helper2(long first, long second) {
        long res = 0;
        while (first >= second) {
            res++;
            first -= second;
        }
        return res;
    }
}

