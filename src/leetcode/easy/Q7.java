package leetcode.easy;

public class Q7 {
}

//Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
class Q7Solution {
    public int reverse(int x) {
        //first check the corner case;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int positive = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            int temp = res * 10 + (x % 10);
            if ((temp - x % 10) / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return positive * res;
    }
}