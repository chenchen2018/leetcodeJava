package leetcode.medium;

/**
 * Created by cchen on 2/2/18.
 */
public class Q474 {
}

class Q474Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int l = strs.length;
        int[] count1 = new int[l], count0 = new int[l];
        for (int index = 0; index < strs.length; index++) {
            int ones = 0, zeros = 0;
            for (char c : strs[index].toCharArray()) {
                if (c == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            count1[index] = ones;
            count0[index] = zeros;
        }
        int[][][] f = new int[l + 1][m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[0][i][j] = 0;
            }
        }
        for (int i = 1; i <= l; i++) {
            for (int M = 0; M <= m; M++) {
                for (int N = 0; N <= n; N++) {
                    f[i][M][N] = f[i - 1][M][N];
                    if (M >= count0[i - 1] && N >= count1[i - 1]) {
                        f[i][M][N] = Math.max(f[i][M][N], f[i - 1][M - count0[i - 1]][N - count1[i - 1]] + 1);
                    }
                }
            }
        }
        return f[l][m][n];
    }
}