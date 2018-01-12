package leetcode.medium;

/**
 * Created by cchen on 1/11/18.
 */
public class Q96 {
}

class Q96Solution {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int num = 2; num <= n; num++) {
            for (int root = 1; root <= num; root++) {
                dp[num] += dp[root - 1] * dp[num - root];
            }
        }
        return dp[n];
    }
}