package leetcode.easy;

public class Q231 {
}

class Q231Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            return false;
        }
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                return (n >> 1) == 0;
            }
            n >>= 1;
        }
        return false;
    }
}