package leetcode.medium;

public class Q794 {
}

class Q794Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount != oCount && xCount != oCount + 1) {
            return false;
        }
        if (doesPlayWin(board, 'X') && xCount != oCount + 1) {
            return false;
        }
        if (doesPlayWin(board, 'O') && xCount != oCount) {
            return false;
        }
        return true;
    }

    private boolean doesPlayWin(String[] board, char p) {
        //check horizontal and vertical
        for (int i = 0; i < 3; i++) {
            //row
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
            //col
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
        }
        //dia
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        //anti-dia
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}