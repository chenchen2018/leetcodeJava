package leetcode.medium;

public class Q5 {
}

class Q5Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        for (int index = 0; index < s.length(); index++) {
            String candidate1 = getLongestSubstringLength(s, index, index);
            res = res.length() >= candidate1.length() ? res : candidate1;
            if (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {
                String candidate2 = getLongestSubstringLength(s, index, index + 1);
                res = res.length() > candidate2.length() ? res : candidate2;
            }
        }
        return res;
    }

    private String getLongestSubstringLength(String source, int left, int right) {
        if (left < 0 || right >= source.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(source.substring(left, right + 1));
        left--;
        right++;
        while (left >= 0 && right < source.length()) {
            char leftChar = source.charAt(left), rightChar = source.charAt(right);
            if (leftChar != rightChar) {
                return sb.toString();
            }
            sb.append(rightChar);
            sb.insert(0, leftChar);
            left--;
            right++;
        }
        return sb.toString();
    }
}