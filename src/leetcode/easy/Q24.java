package leetcode.easy;

public class Q24 {
}

class Q24Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        while (aIndex >= 0 || bIndex >= 0) {
            if (aIndex >= 0) {
                carry += a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                carry += b.charAt(bIndex--) - '0';
            }
            sb.insert(0, carry % 2);
            carry /= 2;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}