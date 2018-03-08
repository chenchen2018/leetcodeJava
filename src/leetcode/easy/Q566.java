package leetcode.easy;

public class Q566 {
}

class Q566Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int rows = nums.length, cols = nums[0].length;
        if (rows * cols != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;
                res[index / c][index % c] = nums[row][col];
            }
        }
        return res;
    }
}