package leetcode.easy;

public class Q263 {
}

class Q263Solution {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        int lastNum = num;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            }
            if (num % 3 == 0) {
                num /= 3;
            }
            if (num % 5 == 0) {
                num /= 5;
            }
            if (num == lastNum) {
                return false;
            }
            lastNum = num;
        }
        return true;
    }
}