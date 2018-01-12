package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public static void main(String[] args) {
        new Q51Solution().solveNQueens(3);
    }
}

class Q51Solution {
    //The rules between different columns of queens:
    //(1) No queens at same row
    //(2) No queens at same column
    //(3) Adjacent columns, position differ by > 1
    //(4) No queens at diagonal
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        if (n == 1) {
            List<String> simpleRes = new ArrayList<>();
            simpleRes.add("Q");
            res.add(simpleRes);
            return res;
        }
        List<String> board = initBoard(n);
        boolean[][] positionTaken = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            addNewColumn(board, row);
            positionTaken[row][0] = true;
            helper(res, board, positionTaken, 1, n, row);
            undo(board);
            positionTaken[row][0] = false;
        }
        return res;
    }

    private void helper(List<List<String>> res, List<String> board, boolean[][] positionTaken, int col, int n, int lastRowPosition) {
        if (col >= n) {
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isPositionValid(lastRowPosition, row) && !hasDiagonalQueen(positionTaken, row, col) && !hasSameRowQueen(positionTaken, row)) {
                positionTaken[row][col] = true;
                addNewColumn(board, row);
                if (col == n - 1) {
                    res.add(new ArrayList<>(board));
                    return;
                }
                helper(res, board, positionTaken, col + 1, n, row);
                positionTaken[row][col] = false;
                undo(board);
            }
        }
    }

    private boolean hasSameRowQueen(boolean[][] positionTaken, int row) {
        for (int col = 0; col < positionTaken.length; col++) {
            if (positionTaken[row][col]) {
                return true;
            }
        }
        return false;
    }

    private void addNewColumn(List<String> board, int queueIndex) {
        for (int index = 0; index < board.size(); index++) {
            if (index == queueIndex) {
                board.set(index, board.get(index) + "Q");
                continue;
            }
            board.set(index, board.get(index) + ".");
        }
    }

    private void undo(List<String> board) {
        if (board.get(0).isEmpty()) {
            return;
        }
        for (int index = 0; index < board.size(); index++) {
            String temp = board.get(index);
            board.set(index, temp.substring(0, temp.length() - 1));
        }
    }


    private boolean isPositionValid(int oldRow, int row) {
        return row < oldRow - 1 || row > oldRow + 1;
    }

    private boolean hasDiagonalQueen(boolean[][] positionTaken, int row, int col) {
        //check upper left diagonal
        int newRow = row - 1, newCol = col - 1;
        while (newRow >= 0 && newCol >= 0) {
            if (positionTaken[newRow][newCol]) {
                return true;
            }
            newRow--;
            newCol--;
        }
        //check lower left diagonal
        newRow = row + 1;
        newCol = col - 1;
        while (newRow < positionTaken.length && newCol >= 0) {
            if (positionTaken[newRow][newCol]) {
                return true;
            }
            newRow++;
            newCol--;
        }
        return false;
    }


    private List<String> initBoard(int n) {
        List<String> res = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            res.add("");
        }
        return res;
    }

}