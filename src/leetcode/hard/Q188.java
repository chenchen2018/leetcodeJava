package leetcode.hard;

/**
 * Created by cchen on 1/27/18.
 */
public class Q188 {
}

class Q188Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            //best time to buy and sell stock II
            int res = 0;
            for (int day = 0; day < n - 1; day++) {
                if (prices[day + 1] > prices[day]) {
                    res += prices[day + 1] - prices[day];
                }
            }
            return res;
        }

        int[][] f = new int[n + 1][2 * k + 1 + 1];
        f[0][1] = 0;
        for (int j = 2; j <= 2 * k + 1; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            //for 1, 3, 5, 7...
            for (int j = 1; j <= 2 * k + 1; j += 2) {
                f[i][j] = f[i - 1][j];
                if (i > 1 && j > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            //for 2, 4, 6, 8...
            for (int j = 2; j <= 2 * k + 1; j += 2) {
                f[i][j] = f[i - 1][j - 1];
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                if (i > 1 && j > 2 && f[i - 1][j - 2] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 2] + prices[i - 1] - prices[i - 2]);
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= 2 * k + 1; j += 2) {
            res = Math.max(f[n][j], res);
        }
        return res;
    }
}