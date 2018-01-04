package leetcode.medium;

/**
 * Created by chen on 1/4/18.
 */
public class Q63 {
}

class Q63Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (dp[0][0] == 0) {
            return 0;
        }
        //init first row
        for (int col = 1; col < cols; col++) {
            if (obstacleGrid[0][col] == 1) {
                dp[0][col] = 0;
            } else {
                dp[0][col] = dp[0][col - 1];
            }
        }
        //init first col
        for (int row = 1; row < rows; row++) {
            if (obstacleGrid[row][0] == 1) {
                dp[row][0] = 0;
            } else {
                dp[row][0] = dp[row - 1][0];
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}