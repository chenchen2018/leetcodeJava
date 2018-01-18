package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q130 {
}

class Q130Solution {
    //first let's do it in dfs way. this time i won't use extra memory space. instead, i will be working on current 2-d array.
    //X stands for sea, O stands for island
    //F stands for an O but already taken care with.
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;
        //start with first row
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'X' || board[0][col] == 'F') {
                continue;
            }
            helper(board, 0, col);
        }
        //last row
        for (int col = 0; col < cols; col++) {
            if (board[rows - 1][col] == 'X' || board[rows - 1][col] == 'F') {
                continue;
            }
            helper(board, rows - 1, col);
        }
        //first col
        for (int row = 1; row < rows - 1; row++) {
            if (board[row][0] == 'X' || board[row][0] == 'F') {
                continue;
            }
            helper(board, row, 0);
        }
        //last col
        for (int row = 1; row < rows - 1; row++) {
            if (board[row][cols - 1] == 'X' || board[row][cols - 1] == 'F') {
                continue;
            }
            helper(board, row, cols - 1);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'F') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    private void helper(char[][] board, int row, int col) {
        board[row][col] = 'F';
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i], newCol = col + dy[i];
            if (isPositionValid(board, newRow, newCol) && board[newRow][newCol] == 'O') {
                helper(board, newRow, newCol);
            }
        }
    }

    private boolean isPositionValid(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        return true;
    }

    //BFS solution
    //cool. TLE again.
    public void solve2(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        int rows = board.length, cols = board[0].length;
        //first row
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                queue.offer(new int[]{0, col});
                bfs(board, queue);
            }
        }
        //last row
        for (int col = 0; col < cols; col++) {
            if (board[rows - 1][col] == 'O') {
                queue.offer(new int[]{rows - 1, col});
                bfs(board, queue);
            }
        }
        //first col
        for (int row = 1; row < rows - 1; row++) {
            if (board[row][0] == 'O') {
                queue.offer(new int[]{row, 0});
                bfs(board, queue);
            }
        }
        //last col
        for (int row = 1; row < rows - 1; row++) {
            if (board[row][cols - 1] == 'O') {
                queue.offer(new int[]{row, cols - 1});
                bfs(board, queue);
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'F') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            board[position[0]][position[1]] = 'F';
            for (int i = 0; i < dx.length; i++) {
                int row = position[0] + dx[i], col = position[1] + dy[i];
                if (isPositionValid(board, row, col) && board[row][col] == 'O') {
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
}

//copy from nine chapter, version 1 which will pass
class Q130SolutionNineChapterVersion1 {
    static final int[] directionX = {+1, -1, 0, 0};
    static final int[] directionY = {0, 0, +1, -1};

    static final char FREE = 'F';
    static final char TRAVELED = 'T';

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            bfs(board, i, 0);               //first col
            bfs(board, i, col - 1);         //last col
        }

        for (int j = 1; j < col - 1; j++) {
            bfs(board, 0, j);               //first row
            bfs(board, row - 1, j);         //last row
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch(board[i][j]) {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(i, j));

        while (!queue.isEmpty()) {
            Node crt = queue.poll();
            board[crt.x][crt.y] = FREE;     //FREE: u r good to go.

            for (Node node : expand(board, crt)) {
                queue.offer(node);
            }
        }
    }

    private List<Node> expand(char[][] board, Node node) {
        List<Node> expansion = new ArrayList<Node>();

        for (int i = 0; i < directionX.length; i++) {
            int x = node.x + directionX[i];
            int y = node.y + directionY[i];

            // check validity
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                board[x][y] = TRAVELED;
                expansion.add(new Node(x, y));
            }
        }

        return expansion;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}