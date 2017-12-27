package leetcode.easy;

public class Q69 {
    public static void main(String[] args) {
        new Q69Solution().mySqrt(2147483647);
    }
}

class Q69Solution {
    public int mySqrt(int x) {
        long left = 0, right = x / 2 + 1;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            if (temp == x) {
                return (int)mid;
            } else if (temp < x) {
                left = (int)mid;
            } else {
                right = (int)mid;
            }
        }
        if (right * right <= x) {
            return (int)right;
        }
        return (int)left;
    }
}