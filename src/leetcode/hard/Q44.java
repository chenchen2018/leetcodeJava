package leetcode.hard;

import java.util.TreeSet;

public class Q44 {
    public static void main(String[] args) {
        String s = "aab", p = "?a";
        System.out.println(new Solution().isMatch(s, p));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) {
            return p == null || p.length() == 0;
        }
        if (p == null || p.length() == 0) {
            return false;
        }
        return isMatchHelper(s, 0, p, 0);
    }

    private boolean isMatchHelper(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex == s.length()) {
            return allStars(p.substring(pIndex));
        }
        if (pIndex == p.length()) {
            return false;
        }
        char pChar = p.charAt(pIndex);
        if (pChar == '?') {
            return isMatchHelper(s, sIndex + 1, p, pIndex + 1);
        } else if (pChar == '*') {
            for (int startIndex = sIndex; startIndex <= s.length(); startIndex++) {
                if (isMatchHelper(s, startIndex, p, pIndex + 1)) {
                    return true;
                }
            }
            //return helper(s, sIndex, p, pIndex + 1) || helper(s, sIndex + 1, p, pIndex); but this one will TLE
            return false;
        } else {
            if (pChar != s.charAt(sIndex)) {
                return false;
            }
            return isMatchHelper(s, sIndex + 1, p, pIndex + 1);
        }
    }

    private boolean allStars(String s) {
        return s.chars().allMatch(c -> c == '*');
    }

    public boolean isMatch2(String s, String p) {
        // without this optimization, it will fail for large data set
        int plenNoStar = 0;
        for (char c : p.toCharArray())
            if (c != '*') plenNoStar++;
        if (plenNoStar > s.length()) return false;

        s = " " + s;
        p = " " + p;
        int slen = s.length();
        int plen = p.length();

        boolean[] dp = new boolean[slen];
        TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
        firstTrueSet.add(0);
        dp[0] = true;

        boolean allStar = true;
        for (int pi = 1; pi < plen; pi++) {
            if (p.charAt(pi) != '*')
                allStar = false;
            for (int si = slen - 1; si >= 0; si--) {
                if (si == 0) {
                    dp[si] = allStar ? true : false;
                } else if (p.charAt(pi) != '*') {
                    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') dp[si] = dp[si-1];
                    else dp[si] = false;
                } else {
                    int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();
                    if (si >= firstTruePos) dp[si] = true;
                    else dp[si] = false;
                }
                if (dp[si]) firstTrueSet.add(si);
                else firstTrueSet.remove(si);
            }
        }
        return dp[slen - 1];
    }

    public boolean isMatch3(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        //f[i][j] stands for if s's first i characters can match p's first j characters
        //f[i][j] = f[i - 1][j - 1] if p's j - 1th character is . or equal to s's i - 1 th.
        //f[i][j] = f[i - 1][j] || f[i][j - 1] if it's ?
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = true;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = false;
                if (p.charAt(j - 1) == '*') {
                    f[i][j] |= f[i][j - 1];
                    if (i > 0) {
                        f[i][j] |= f[i - 1][j];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        f[i][j] |= f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
}
