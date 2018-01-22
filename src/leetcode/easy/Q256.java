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

    //用序列型做一下
    public int minCost2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int houses = costs.length;
        int[][] f = new int[houses + 1][3];
        for (int house = 1; house <= houses; house++) {
            for (int color = 0; color < costs[0].length; color++) {
                f[house][color] = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < costs[0].length; prevColor++) {
                    if (color != prevColor) {
                        f[house][color] = Math.min(f[house][color], f[house - 1][prevColor] + costs[house - 1][color]);
                    }
                }
            }
        }
        return Math.min(f[houses][0], Math.min(f[houses][1], f[houses][2]));
    }

    //还是序列型 但是这次只用两个数组
    public int minCost3(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int houses = costs.length;
        int[][] f = new int[2][3];

        int old = 1, now = 0;

        for (int house = 1; house <= houses; house++) {
            old = now;
            now = 1 - now;
            for (int color = 0; color < 3; color++) {
                f[now][color] = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < 3; prevColor++) {
                    if (color != prevColor) {
                        f[now][color] = Math.min(f[now][color], f[old][prevColor] + costs[house - 1][color]);
                    }
                }
            }
        }

        return Math.min(f[now][0], Math.min(f[now][1], f[now][2]));
    }
}