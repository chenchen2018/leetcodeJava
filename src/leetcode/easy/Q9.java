package leetcode.easy;

public class Q9 {
}

class Q9Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int scale = getScale(x);
        while (scale > 9) {
            int leftDigit = x / scale, rightDight = x % 10;
            if (leftDigit != rightDight) {
                return false;
            }
            x %= scale;
            x /= 10;
            scale /= 100;
        }
        return true;
    }

    private int getScale(int x) {
        int scale = 1;
        while (x / scale >= 10) {
            scale *= 10;
        }
        return scale;
    }
}
