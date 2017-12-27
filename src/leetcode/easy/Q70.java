package leetcode.easy;

public class Q70 {
}

class Q70Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int stair = 3; stair <= n; stair++) {
            dp[stair] = dp[stair - 1] + dp[stair - 2];
        }
        return dp[n];
    }
}