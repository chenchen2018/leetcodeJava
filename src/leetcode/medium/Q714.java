package leetcode.medium;

public class Q714 {
}

class Q714Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        //f[i][1] stands for holding a stock, f[i][0] stands for holding a cash
        f[1][0] = 0;
        f[1][1] = -prices[0];
        for (int day = 2; day <= n; day++) {
            f[day][0] = Math.max(f[day - 1][0], f[day - 1][1] + prices[day - 1] - fee);
            f[day][1] = Math.max(f[day - 1][0] - prices[day - 1], f[day - 1][1]);
        }
        return f[n][0];
    }
}