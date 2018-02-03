package lintcode.hard;

/**
 * Created by cchen on 2/3/18.
 */
public class Q89 {
}

class Q89Solution {
    public int kSum(int[] A, int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        //f[i][j][s] stands for first i nums, picking j elements, the ways can form s
        for (int j = 0; j <= k; j++) {
            for (int s = 0; s <= target; s++) {
                f[0][j][s] = 0;
            }
        }
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int s = 0; s <= target; s++) {
                    f[i][j][s] = f[i - 1][j][s];
                    if (j > 0 && s >= A[i - 1]) {
                        f[i][j][s] += f[i - 1][j - 1][s - A[i - 1]];
                    }
                }
            }
        }
        return f[n][k][target];
    }
}