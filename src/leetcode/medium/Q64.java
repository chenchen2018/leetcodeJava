package leetcode.medium;

/**
 * Created by chen on 1/4/18.
 */
public class Q64 {
}

class Q64Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] sum = new int[rows][cols];
        sum[0][0] = grid[0][0];
        //init first row
        for (int col = 1; col < cols; col++) {
            sum[0][col] = sum[0][col - 1] + grid[0][col];
        }
        //init first col
        for (int row = 1; row < rows; row++) {
            sum[row][0] = sum[row - 1][0] + grid[row][0];
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                sum[row][col] = grid[row][col] + Math.min(sum[row - 1][col], sum[row][col - 1]);
            }
        }
        return sum[rows - 1][cols - 1];
    }
}