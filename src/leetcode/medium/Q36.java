package leetcode.medium;

import java.util.Arrays;

/**
 * Created by chen on 12/30/17.
 */
public class Q36 {
}

class Q36Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[] visited = new boolean[9];
        //check each row
        for (int row = 0; row < board.length; row++) {
            if (!checkRow(board[row], visited)) {
                return false;
            }
            resetIndicator(visited);
        }
        //check each col
        for (int col = 0; col < board[0].length; col++) {
            if (!checkCol(board, col, visited)) {
                return false;
            }
            resetIndicator(visited);
        }
        //check sub
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!checkSub(board, row, col, visited)) {
                    return false;
                }
                resetIndicator(visited);
            }
        }
        return true;
    }

    private boolean checkRow(char[] row, boolean[] visited) {
        for (char c : row) {
            if (c == '.') {
                continue;
            }
            if (visited[c - '1']) {
                return false;
            }
            visited[c - '1'] = true;
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col, boolean[] visited) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == '.') {
                continue;
            }
            if (visited[board[row][col] - '1']) {
                return false;
            }
            visited[board[row][col] - '1'] = true;
        }
        return true;
    }

    private boolean checkSub(char[][] board, int rowIndex, int colIndex, boolean[] visited) {
        for (int row = rowIndex * 3; row < rowIndex * 3 + 3; row++) {
            for (int col = colIndex * 3; col < colIndex * 3 + 3; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (visited[board[row][col] - '1']) {
                    return false;
                }
                visited[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private void resetIndicator(boolean[] visited) {
        Arrays.fill(visited, false);
    }
}
