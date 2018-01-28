package lintcode.hard;

/**
 * Created by cchen on 1/27/18.
 */
public class Q437 {
}

class Q437Solution {
    public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        if (k > n) {
             k = n;
        }
        int[][] f = new int[k + 1][n + 1];
        f[0][0] = 0;
        for (int book = 1; book <= n; book++) {
            f[0][book] = Integer.MAX_VALUE;
        }
        for (int copier = 1; copier <= k; copier++) {
            f[copier][0] = 0;
        }
        for (int copier = 1; copier <= k; copier++) {
            for (int i = 1; i <= n; i++) {
                f[copier][i] = Integer.MAX_VALUE;
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    f[copier][i] = Math.min(f[copier][i], Math.max(f[copier - 1][j], sum));
                    if (j > 0) {
                        sum += pages[j - 1];
                    }
                }
            }
        }
        return f[k][n];
    }
}