package leetcode.hard;

/**
 * Created by cchen on 2/5/18.
 */
public class Q174 {
}

class Q174Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rows = dungeon.length, cols = dungeon[0].length;
        int[][] f = new int[rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (row == rows - 1 && col == cols - 1) {
                    if (dungeon[row][col] < 0) {
                        f[row][col] = -dungeon[row][col] + 1;
                    } else {
                        f[row][col] = 1;
                    }
                    continue;
                }
                int minHp = Integer.MAX_VALUE;
                if (row != rows - 1) {
                    minHp = Math.min(minHp, f[row + 1][col]);
                }
                if (col != cols - 1) {
                    minHp = Math.min(minHp, f[row][col + 1]);
                }
                if (minHp <= dungeon[row][col]) {
                    f[row][col] = 1;
                } else {
                    f[row][col] = minHp - dungeon[row][col];
                }
            }
        }
        return f[0][0];
    }
}