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

    //let's do dp!!!!
    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        //f[i][j] stands for if s's first i characters can match p's first j characters
        //f[i][j] = f[i - 1][j - 1] if it's . or exactly match
        //f[i][j] = f[i][j - 2] || f[i - 1][j]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = false;
                if (p.charAt(j - 1) == '*') {
                    if (i > 0 && j > 1) {
                        if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                    if (j > 1) {
                        f[i][j] |= f[i][j - 2];
                    }
                } else {
                    if (i > 0) {
                        if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                            f[i][j] |= f[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }
}