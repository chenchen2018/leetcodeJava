package leetcode.easy;

public class Q463 {
}

class Q463Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    for (int i = 0; i < dx.length; i++) {
                        if (isWater(row + dx[i], col + dy[i], grid)) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isWater(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return true;
        }
        return grid[x][y] == 0;
    }
}