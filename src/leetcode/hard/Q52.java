package leetcode.hard;

public class Q52 {
    public static void main(String[] args) {
        new Q52Solution().totalNQueens(4);
    }
}

class Q52Solution {
    int counter = 0;

    public int totalNQueens(int n) {
        if (n < 2) {
            return 1;
        }
        boolean[][] positionTaken = new boolean[n][n];
        counter = 0;
        for (int row = 0; row < n; row++) {
            positionTaken[row][0] = true;
            helper(positionTaken, 1, row, n);
            positionTaken[row][0] = false;
        }
        return counter;
    }

    private void helper(boolean[][] positionTaken, int currCol, int lastRowSelected, int n) {
        if (currCol >= n) {
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isValidPosition(lastRowSelected, row) && !hasDiagonalQueen(positionTaken, row, currCol) && !hasRowQueen(positionTaken, row)) {
                positionTaken[row][currCol] = true;
                if (currCol == n - 1) {
                    counter++;
                }
                helper(positionTaken, currCol + 1, row, n);
                positionTaken[row][currCol] = false;
            }
        }
    }

    private boolean hasRowQueen(boolean[][] positionTaken, int row) {
        for (int col = 0; col < positionTaken.length; col++) {
            if (positionTaken[row][col]) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDiagonalQueen(boolean[][] positionTaken, int row, int col) {
        int currRow = row - 1, currCol = col - 1;
        while (currRow >= 0 && currCol >= 0) {
            if (positionTaken[currRow][currCol]) {
                return true;
            }
            currRow--;
            currCol--;
        }
        currRow = row + 1;
        currCol = col - 1;
        while (currRow < positionTaken.length && currCol >= 0) {
            if (positionTaken[currRow][currCol]) {
                return true;
            }
            currRow++;
            currCol--;
        }
        return false;
    }

    private boolean isValidPosition(int oldRow, int row) {
        return row < oldRow - 1 || row > oldRow + 1;
    }
}