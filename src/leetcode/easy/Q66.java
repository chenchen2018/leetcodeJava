package leetcode.easy;

/**
 * Created by chen on 12/27/17.
 */
public class Q66 {
}

class Q66Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        for (int index = digits.length - 1; index >= 0; index--) {
            carry += digits[index];
            sb.insert(0, carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        int[] res = new int[sb.length()];
        for (int index = 0; index < res.length; index++) {
            res[index] = sb.charAt(index) - '0';
        }
        return res;
    }
}
