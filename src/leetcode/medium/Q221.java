package leetcode.medium;

/**
 * Created by cchen on 2/3/18.
 */
public class Q221 {
}

class Q221Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] f = new int[rows][cols];
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '0') {
                    f[row][col] = 0;
                    continue;
                }
                if (row == 0 || col == 0) {
                    f[row][col] = 1;
                } else {
                    f[row][col] = Math.min(f[row - 1][col], Math.min(f[row][col - 1], f[row - 1][col - 1])) + 1;
                }
                res = Math.max(res, f[row][col] * f[row][col]);
            }
        }
        return res;
    }
}