package leetcode.hard;

public class Q115 {
}

class Q115Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        if (t.isEmpty()) {
            return 1;
        }
        int m = s.length(), n = t.length();
        int[][] f = new int[m + 1][n + 1];
        //f[i][j] stands for how many distinct times t's first j characters occur in s's first i characters
        //f[i][j] = f[i - 1][j] || f[i - 1][j - 1] + f[i - 1][j] if they have same last character
        //init: f[0][0] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = 1;
                    continue;
                }
                f[i][j] = 0;
                if (i > 0) {
                    f[i][j] = f[i - 1][j];
                    if (j > 0 && s.charAt(i - 1) == t.charAt(j - 1)) {
                        f[i][j] += f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
}