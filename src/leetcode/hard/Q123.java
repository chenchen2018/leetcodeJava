package leetcode.hard;

/**
 * Created by cchen on 1/26/18.
 */
public class Q123 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4};
        new Q123Solution().maxProfit(prices);
    }
}

class Q123Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] f = new int[n + 1][6];
        f[0][1] = 0;
        for (int i = 2; i <= 5; i++) {
            f[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j+=2) {
                f[i][j] = f[i - 1][j];
                if (i > 1 && j > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            for (int j = 2; j <= 5; j+=2) {
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
        for (int i = 1; i <= 5; i += 2) {
            res = Math.max(res, f[n][i]);
        }
        return res;
    }
}