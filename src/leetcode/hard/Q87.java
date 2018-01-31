package leetcode.hard;

/**
 * Created by cchen on 1/30/18.
 */
public class Q87 {
}

class Q87Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        boolean[][][][] f = new boolean[n][n][n][n];
        //init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][i][j][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j  = i + len - 1;
                for (int k = 0; k <= n - len; k++) {
                    int h = k + len - 1;
                    f[i][j][k][h] = false;
                    for (int w = i; w < j; w++) {
                        if (f[i][w][k][k + w - i] && f[w + 1][j][k + w + 1 - i][h]) {
                            f[i][j][k][h] = true;
                            break;
                        }
                        if (f[i][w][h - w + i][h] && f[w + 1][j][k][k + j - w - 1]) {
                            f[i][j][k][h] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][n - 1][0][n - 1];
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    f[i][j][k] = false;
                    for (int w = 1; w < k; w++) {
                        if (f[i][j][w] && f[i + w][j + w][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                        if (f[i][j + k - w][w] && f[i + w][j][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}