package leetcode.medium;

public class Q79 {
}

class Q79Solution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        int rows = board.length, cols = board[0].length;
        if (rows * cols < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (helper(board, word, visited, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (!inRange(board, row, col) || board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i], newCol = col + dy[i];
            if (helper(board, word, visited, newRow, newCol, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private boolean inRange(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        return true;
    }
}