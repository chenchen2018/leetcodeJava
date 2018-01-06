package leetcode.medium;

/**
 * Created by chen on 1/5/18.
 */
public class Q73 {
}

class Q73Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean firstRow = false;
        for (int num : matrix[0]) {
            if (num == 0) {
                firstRow = true;
                break;
            }
        }
        boolean firstCol = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (firstRow) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if (firstCol) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}