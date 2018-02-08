package leetcode.medium;

public class Q718 {
}

class Q718Solution {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int m = A.length, n = B.length;
        int[][] f = new int[m + 1][n + 1];
        //f[i][j] stands for the longest length for first i letters in A and first j letters in B, also the last letters are same for both string
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (B[j - 1] == A[i - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    res = Math.max(res, f[i][j]);
                }
            }
        }
        return res;
    }
}