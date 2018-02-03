package lintcode.medium;

import java.util.List;

/**
 * Created by cchen on 2/3/18.
 */
public class Q91 {
}

class Q91Solution {
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        //f[i][j]: for the first i integers, the minimum cost for adjustment and also change A[i - 1] to j and also
        //first i integers satisfy the condition that 2 adjacent elements's diff no large than target
        int n = A.size();
        int[][] f = new int[n + 1][101];
        //init f[1][j] = |j - A.get(i)|
        for (int j = 1; j <= 100; j++) {
            f[1][j] = Math.abs(j - A.get(0));
        }
        //f[i][j] = f[i - 1][k] + |A[i - 1] - j|, where k is j - target <= k <= j + target
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = j - target; k <= j + target; k++) {
                    if (k < 1 || k > 100) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(j - A.get(i - 1)));
                }
            }
        }
        //get result
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, f[n][i]);
        }
        return res;
    }
}