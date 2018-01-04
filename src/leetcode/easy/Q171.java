package leetcode.easy;

/**
 * Created by chen on 1/4/18.
 */
public class Q171 {
}

class Q171Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        int base = 1;
        for (int index = s.length() - 1; index >= 0; index--) {
            int digit = s.charAt(index) - 'A' + 1;
            if (digit % 26 == 0) {
                res += 26 * base;
            } else {
                res += base * digit;
            }
            base *= 26;
        }
        return res;
    }
}