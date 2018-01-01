package leetcode.easy;

/**
 * Created by chen on 1/1/18.
 */
public class Q122 {
}

class Q122Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int buyPrice = prices[0];
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] >= buyPrice) {
                profit += prices[index] - buyPrice;
            }
            buyPrice = prices[index];
        }
        return profit;
    }
}