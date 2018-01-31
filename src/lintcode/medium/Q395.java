package lintcode.medium;

/**
 * Created by cchen on 1/30/18.
 */
public class Q395 {
}

class Q395Solution {
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return true;
        }
        int n = values.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = values[i];
        }
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = Math.abs(values[i] - values[i + 1]);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(values[i] - f[i + 1][j],
                        values[i] + values[i + 1] - f[i + 2][j]);
            }
        }
        return f[0][n - 1] >= 0;
    }
}