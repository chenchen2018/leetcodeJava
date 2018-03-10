package leetcode.easy;

/**
 * Created by cchen on 3/10/18.
 */
public class Q693 {
    public static void main(String[] args) {
        new Q693Solution().hasAlternatingBits(5);
    }
}

class Q693Solution {
    public boolean hasAlternatingBits(int n) {
        if (n < 1) {
            return false;
        }
        int indicator = (n & 1);
        while (n > 0) {
            if ((n & 1) != indicator) {
                return false;
            }
            n >>= 1;
            indicator = 1 - indicator;
        }
        return true;
    }
}
