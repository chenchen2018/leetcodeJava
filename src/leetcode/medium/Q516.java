package leetcode.medium;

/**
 * Created by cchen on 1/30/18.
 */
public class Q516 {
}

class Q516Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = ss[i] == ss[i + 1] ? 2 : 1;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                if (ss[i] == ss[j]) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[0][n - 1];
    }

    int[][] f;
    char[] ss;
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        f = new int[n][n];
        ss = s.toCharArray();
        compute(0, n - 1);
        return f[0][n - 1];
    }

    private void compute(int left, int right) {
        if (f[left][right] != 0) {
            return;
        }
        if (left == right) {
            f[left][left] = 1;
            return;
        }
        if (left + 1 == right) {
            f[left][right] = ss[left] == ss[right] ? 2 : 1;
            return;
        }
        compute(left + 1, right);
        compute(left, right - 1);
        compute(left + 1, right - 1);
        f[left][right] = Math.max(f[left + 1][right], f[left][right - 1]);
        if (ss[left] == ss[right]) {
            f[left][right] = Math.max(f[left][right], f[left + 1][right - 1] + 2);
        }
    }
}