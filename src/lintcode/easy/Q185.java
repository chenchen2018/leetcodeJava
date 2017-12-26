package lintcode.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q185 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int[] res = new Q185Solution().matrixZigzagTraversal(matrix);
        IntStream.of(res).forEach(System.out::println);
    }
}

class Q185Solution {
    public int[] matrixZigzagTraversal(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        if (res.length == 0) {
            return res;
        }
        boolean upRight = true;
        int startX = 0, startY = 0;
        int resultIndex = 0;
        while (isValid(startX, 0, rows - 1) && isValid(startY, 0, cols - 1)) {
            while (isValid(startX, 0, rows - 1) && isValid(startY, 0, cols - 1)) {
                res[resultIndex++] = matrix[startX][startY];
                if (upRight) {
                    startX--;
                    startY++;
                } else {
                    startX++;
                    startY--;
                }
            }
            if (upRight) {
                startX++;
                startY--;
            } else {
                startX--;
                startY++;
            }
            int nextX = startX, nextY = startY;
            if (upRight) {
                nextY = startY + 1;
                if (nextY >= cols) {
                    nextY = startY;
                    nextX = startX + 1;
                }
            } else {
                nextX = startX + 1;
                if (nextX >= rows) {
                    nextX = startX;
                    nextY = startY + 1;
                }
            }
            startX = nextX;
            startY = nextY;
            upRight = upRight ? false : true;
        }
        return res;
    }

    private boolean isValid(int position, int lowerBound, int upperBound) {
        return position >= lowerBound && position <= upperBound;
    }
}
