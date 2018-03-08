package leetcode.easy;

public class Q766 {
}

class Q766Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row > 0 && col > 0) {
                    if (matrix[row][col] != matrix[row - 1][col - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}