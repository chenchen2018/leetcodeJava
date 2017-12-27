package leetcode.hard;

//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true


public class Q10 {
}

class Q10Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean firstLetterMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
            return isMatch(s, p.substring(2)) || (firstLetterMatch && isMatch(s.substring(1), p));
        } else {
            if (s.length() == 0) {
                return false;
            }
            char c = p.charAt(0);
            if (c == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                if (c != s.charAt(0)) {
                    return false;
                }
                return isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}