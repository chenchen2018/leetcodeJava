package lintcode.medium;

public class Q77 {
}

class Q77Solution {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length(), n = B.length();
        int[][] f = new int[m + 1][n + 1];
        //f[i][j] stands for longest common subsequence for first i characters in A and first j characters in B
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }
        }
        return f[m][n];
    }
}