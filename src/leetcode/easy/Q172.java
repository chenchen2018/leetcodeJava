package leetcode.easy;

/**
 * Created by chen on 1/4/18.
 */
public class Q172 {
}

class Q172Solution {
    public int trailingZeroes(int n) {
        int base = 5, res = 0;
        while (n >= base) {
            res += n / base;
            if (n / base >= 5) {
                base *= 5;
            } else {
                break;
            }
        }
        return res;
    }
}