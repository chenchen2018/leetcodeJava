package leetcode.hard;

import java.util.Arrays;

/**
 * Created by chen on 1/1/18.
 */
public class Q37 {
}

class Q37Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (int candidate = 1; candidate <= 9; candidate++) {
                    board[row][col] = (char)(candidate + '0');
                    if (isValid(board) && solve(board)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board) {
        boolean[] visited = new boolean[9];
        //check rows
        for(char[] row : board) {
            if (!checkRow(row, visited)) {
                return false;
            }
            reset(visited);
        }
        //check cols
        for (int col = 0; col < 9; col++) {
            if (!checkCol(board, col, visited)) {
                return false;
            }
            reset(visited);
        }
        //check subs
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!checkSub(board, row, col, visited)) {
                    return false;
                }
                reset(visited);
            }
        }
        return true;
    }

    private boolean checkRow(char[] board, boolean[] visited) {
        for (int row = 0; row < board.length; row++) {
            if (board[row] == '.') {
                continue;
            }
            if (visited[board[row] - '1']) {
                return false;
            }
            visited[board[row] - '1'] = true;
        }
        return true;
    }

    private boolean checkCol(char[][] board, int colIndex, boolean[] visited) {
        for (int row = 0; row < 9; row++) {
            if (board[row][colIndex] == '.') {
                continue;
            }
            if (visited[board[row][colIndex] - '1']) {
                return false;
            }
            visited[board[row][colIndex] - '1'] = true;
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

    private void reset(boolean[] visited) {
        Arrays.fill(visited, false);
    }
}