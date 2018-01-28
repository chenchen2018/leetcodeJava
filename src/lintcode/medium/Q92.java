package lintcode.medium;

/**
 * Created by cchen on 1/28/18.
 */
public class Q92 {
    public static void main(String[] args) {
        int[] input = {3, 4, 8, 5};
        new Q92Solution().backPack(10, input);
    }
}

class Q92Solution {
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                f[i][w] = f[i - 1][w];
                if (w >= A[i - 1]) {
                    f[i][w] = f[i][w] || f[i - 1][w - A[i - 1]];
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (f[n][i]) {
                return i;
            }
        }
        return 0;
    }
}