package leetcode.hard;

public class Q97 {
}

class Q97Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        //f[i][j] stands for if s1's first i characters and s2's first j characters can interleave s3's first i + j characters.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = true;
                    continue;
                }
                f[i][j] = false;
                if (i > 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        f[i][j] |= f[i - 1][j];
                    }
                }
                if (j > 0) {
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        f[i][j] |= f[i][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
}