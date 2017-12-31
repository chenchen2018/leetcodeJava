package leetcode.medium;

/**
 * Created by chen on 12/31/17.
 */
public class Q48 {
}

class Q48Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        for (int circle = 0; circle < n / 2; circle++) {
            for (int index = 0; index < n - 1 - 2 * circle; index++) {
                int temp = matrix[circle][circle + index];
                //left to top
                matrix[circle][circle + index] = matrix[n - 1 - circle - index][circle];
                //down to left
                matrix[n - 1 - circle - index][circle] = matrix[n - 1 - circle][n - 1 - circle - index];
                //right to down
                matrix[n - 1 - circle][n - 1 - circle - index] = matrix[circle + index][n - 1 - circle];
                //top to right
                matrix[circle + index][n - 1 - circle] = temp;
            }
        }
    }
}