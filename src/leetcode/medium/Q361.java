package leetcode.medium;

public class Q361 {
    public static void main(String[] args) {
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        new Q361Solution().maxKilledEnemies(grid);
    }
}

class Q361Solution {
    //a wall 'W', an enemy 'E' or empty '0' (the number zero)
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        int[][] f = new int[rows][cols], res = new int[rows][cols];

        //up
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                f[row][col] = 0;
                if (grid[row][col] == 'W') {
                    continue;
                }
                if (grid[row][col] == 'E') {
                    f[row][col] = 1;
                }
                if (row > 0) {
                    f[row][col] += f[row - 1][col];
                }
                res[row][col] += f[row][col];
            }
        }

        //down
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                f[row][col] = 0;
                if (grid[row][col] == 'W') {
                    continue;
                }
                if (grid[row][col] == 'E') {
                    f[row][col] = 1;
                }
                if (row + 1 < rows) {
                    f[row][col] += f[row + 1][col];
                }
                res[row][col] += f[row][col];
            }
        }

        //left
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                f[row][col] = 0;
                if (grid[row][col] == 'W') {
                    continue;
                }
                if (grid[row][col] == 'E') {
                    f[row][col] = 1;
                }
                if (col > 0) {
                    f[row][col] += f[row][col - 1];
                }
                res[row][col] += f[row][col];
            }
        }

        //right
        for (int row = 0; row < rows; row++) {
            for (int col = cols - 1; col >= 0; col--) {
                f[row][col] = 0;
                if (grid[row][col] == 'W') {
                    continue;
                }
                if (grid[row][col] == 'E') {
                    f[row][col] = 1;
                }
                if (col + 1 < cols) {
                    f[row][col] += f[row][col + 1];
                }
                res[row][col] += f[row][col];
            }
        }

        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '0') {
                    result = Math.max(result, res[row][col]);
                }
            }
        }
        return result;
    }
}