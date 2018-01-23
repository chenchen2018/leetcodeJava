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

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        int[][] f = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                f[row][col] = grid[row][col];
                if (row == 0 && col == 0) {
                    continue;
                }
                if (row == 0) {
                    f[row][col] += f[row][col - 1];
                } else if (col == 0) {
                    f[row][col] += f[row - 1][col];
                } else {
                    f[row][col] += Math.min(f[row - 1][col], f[row][col - 1]);
                }
            }
        }
        return f[rows - 1][cols - 1];
    }

    //optimize the space usage to only 2 arrays
    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;

        int[][] f = new int[2][cols];

        int old = 1, now = 0;

        for (int row = 0; row < rows; row++) {
            old = now;
            now = 1 - now;
            for (int col = 0; col < cols; col++) {
                f[now][col] = grid[row][col];
                if (row == 0 || col == 0) {
                    continue;
                }
                if (row == 0) {
                    f[now][col] += f[now][col - 1];
                } else if (col == 0) {
                    f[now][col] += f[old][col];
                } else {
                    f[now][col] += Math.min(f[now][col - 1], f[old][col]);
                }
            }
        }
        return f[now][cols - 1];
    }

    //optimize the space usage to only 1 array
    public int minPathSum4(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;

        int[] f = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    f[col] = grid[row][col];
                    continue;
                }
                if (row == 0) {
                    f[col] = f[col - 1] + grid[row][col];
                } else if (col == 0) {
                    f[col] += grid[row][col];
                } else {
                    f[col] = grid[row][col] + Math.min(f[col], f[col - 1]);
                }
            }
        }

        return f[cols - 1];
    }
}