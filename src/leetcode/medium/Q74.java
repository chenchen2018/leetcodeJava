package leetcode.medium;

/**
 * Created by chen on 1/5/18.
 */
public class Q74 {
}

class Q74Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int curr = matrix[mid / cols][mid % cols];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return matrix[left / cols][left % cols] == target || matrix[right / cols][right % cols] == target;
    }
}