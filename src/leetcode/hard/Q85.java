package leetcode.hard;

/**
 * Created by cchen on 2/3/18.
 */
public class Q85 {
}

class Q85Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] up = new int[rows][cols], left = new int[rows][cols], right = new int[rows][cols];
        int res = 0;
        for (int row = 0; row < rows; row++) {
            //up
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '0') {
                    up[row][col] = 0;
                } else {
                    up[row][col] = 1;
                    if (row > 0) {
                        up[row][col] += up[row - 1][col];
                    }
                }
            }

            //left
            int l = 0;
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '0') {
                    l = 0;
                    left[row][col] = 0;
                } else {
                    l++;
                    left[row][col] = l;
                    if (row > 0 && matrix[row - 1][col] == '1') {
                        left[row][col] = Math.min(left[row][col], left[row - 1][col]);
                    }
                }
            }

            //right
            int r = 0;
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '0') {
                    r = 0;
                    right[row][col] = 0;
                } else {
                    r++;
                    right[row][col] = r;
                    if (row > 0 && matrix[row - 1][col] == '1') {
                        right[row][col] = Math.min(right[row][col], right[row - 1][col]);
                    }
                }
            }

            for (int col = 0; col < cols; col++) {
                res = Math.max(res, up[row][col] * (left[row][col] + right[row][col] - 1));
            }
        }
        return res;
    }
}