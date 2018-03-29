package leetcode.medium;

/**
 * Created by cchen on 3/17/18.
 */
public class Q289 {
}

class Q289Solution {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        int[][] copy = copyBoard(board);
        int rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int lives = liveCells(copy, row, col);
                if (board[row][col] == 0) {
                    if (lives == 3) {
                        board[row][col] = 1;
                    }
                } else {
                    if (lives < 2 || lives > 3) {
                        board[row][col] = 0;
                    } else {
                        board[row][col] = 1;
                    }
                }
            }
        }
    }

    private int liveCells(int[][] board, int row, int col) {
        int counter = 0;
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i], newCol = col + dy[i];
            if (inBound(board, newRow, newCol) && board[newRow][newCol] == 1) {
                counter++;
            }
        }
        return counter;
    }

    private boolean inBound(int[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }

    private int[][] copyBoard(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] copy = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy[row][col] = board[row][col];
            }
        }
        return copy;
    }
}
