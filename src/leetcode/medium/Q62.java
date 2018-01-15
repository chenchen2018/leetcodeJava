package leetcode.medium;

/**
 * Created by chen on 1/4/18.
 */
public class Q62 {
}

class Q62Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int col = 1; col < n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 1; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //version 2: rotate array
    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        int[] prev = new int[n], curr = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    curr[col] = 1;
                    continue;
                }
                if (row == 0) {
                    curr[col] = curr[col - 1];
                } else if (col == 0) {
                    curr[row] = prev[row - 1];
                } else {
                    curr[col] = curr[col - 1] + prev[col];
                }
            }
            prev = curr;
        }
        return curr[n - 1];
    }

    //version 3: fashion way of 滚动数组
    public int uniquePath3(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        int[][] f = new int[2][n];
        int prev = 0, curr = 1;
        for (int row = 0; row < m; row++) {
            prev = curr;
            curr = 1 - curr;
            for (int col = 0; col < n; col++) {
                f[curr][col] = 0;
                if (row == 0 && col == 0) {
                    f[curr][col] = 1;
                    continue;
                }
                if (row == 0) {
                    f[curr][col] = f[curr][col - 1];
                } else if (col == 0) {
                    f[curr][col] = f[prev][col];
                } else {
                    f[curr][col] = f[curr][col - 1] + f[prev][col];
                }
            }
        }
        return f[curr][n - 1];
    }
}