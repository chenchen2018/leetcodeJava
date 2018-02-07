package leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cchen on 2/7/18.
 */
public class Q764 {
}

class Q764Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N < 1) {
            return 0;
        }
        int[][] f = new int[N][N], count = new int[N][N];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(N * mine[0] + mine[1]);
        }
        //up
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                count[row][col] = 0;
                if (row == 0) {
                    count[row][col] = set.contains(row * N + col) ? 0 : 1;
                } else {
                    if (!set.contains(row * N + col)) {
                        count[row][col] = 1 + count[row - 1][col];
                    }
                }
                f[row][col] = Math.min(f[row][col], count[row][col]);
            }
        }
        //down
        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col < N; col++) {
                count[row][col] = 0;
                if (row == N - 1) {
                    count[row][col] = set.contains(row * N + col) ? 0 : 1;
                } else {
                    if (!set.contains(row * N + col)) {
                        count[row][col] = 1 + count[row + 1][col];
                    }
                }
                f[row][col] = Math.min(f[row][col], count[row][col]);
            }
        }
        //left
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                count[row][col] = 0;
                if (col == 0) {
                    count[row][col] = set.contains(row * N + col) ? 0 : 1;
                } else {
                    if (!set.contains(row * N + col)) {
                        count[row][col] = 1 + count[row][col - 1];
                    }
                }
                f[row][col] = Math.min(f[row][col], count[row][col]);
            }
        }
        //right
        for (int row = 0; row < N; row++) {
            for (int col = N - 1; col >= 0; col--) {
                count[row][col] = 0;
                if (col == N - 1) {
                    count[row][col] = set.contains(row * N + col) ? 0 : 1;
                } else {
                    if (!set.contains(row * N + col)) {
                        count[row][col] = 1 + count[row][col + 1];
                    }
                }
                f[row][col] = Math.min(f[row][col], count[row][col]);
            }
        }
        //get result
        int res = Integer.MIN_VALUE;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                res = Math.max(res, f[row][col]);
            }
        }
        return res;
    }
}