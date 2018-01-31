package lintcode.medium;

public class Q125 {
}

class Q125Solution {
    public int backPackII(int m, int[] A, int[] V) {
        //so if we know for every weight, the max value we can get, then we know
        int n = A.length;
        //f[i][j] stands for: for first i items, the value we can get when forming weight j
        int[][] f = new int[n + 1][m + 1];
        //init
        f[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            f[0][i] = Integer.MIN_VALUE;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1] && f[i - 1][j - A[i - 1]] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
                }
                res = Math.max(res, f[i][j]);
            }
        }
        return res;
    }
}