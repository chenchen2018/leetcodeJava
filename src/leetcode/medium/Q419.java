package leetcode.medium;

public class Q419 {
}

class Q419Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board.length == 0) {
            return 0;
        }
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    ans++;
                    int pos1 = i, pos2 = j;
                    //以下纯属赖皮写法啊
                    for (int k = 0; k < 4; k++) {
                        while (pos1 + dx[k] >= 0 && pos1 + dx[k] < board.length && pos2 + dy[k] >= 0 && pos2 + dy[k] < board[0].length && board[pos1 + dx[k]][pos2 + dy[k]] == 'X') {
                            board[pos1 + dx[k]][pos2 + dy[k]] = '.';
                            pos1 += dx[k];
                            pos2 += dy[k];
                        }
                    }
                }
            }
        }
        return ans;
    }
}
