package leetcode.medium;

/**
 * Created by chen on 3/31/18.
 */
public class Q348 {
}

class TicTacToe {
    int[] rows, cols, dias;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dias = new int[2];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {     //player 1 puts 1 on board, player 2 puts -1 on board
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            if (row == col) { //left up to right down
                dias[0]++;
            }
            if (row + col == n - 1){
                dias[1]++;
            }
            if (rows[row] == n || cols[col] == n || dias[0] == n || dias[1] == n) {
                return 1;
            }
        } else {
            rows[row]--;
            cols[col]--;
            if (row == col) {
                dias[0]--;
            }
            if (row + col == n - 1) {
                dias[1]--;
            }
            if (rows[row] == -n || cols[col] == -n || dias[0] == -n || dias[1] == -n) {
                return 2;
            }
        }
        return 0;
    }
}