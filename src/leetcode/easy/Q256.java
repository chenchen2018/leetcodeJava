package leetcode.easy;

public class Q256 {
}

class Q256Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int house = 1; house < costs.length; house++) {
            dp[house][0] = costs[house][0] + Math.min(dp[house - 1][1], dp[house - 1][2]);
            dp[house][1] = costs[house][1] + Math.min(dp[house - 1][0], dp[house - 1][2]);
            dp[house][2] = costs[house][2] + Math.min(dp[house - 1][0], dp[house - 1][1]);
        }
        return Math.min(Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]), dp[costs.length - 1][2]);
    }
}