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
}
