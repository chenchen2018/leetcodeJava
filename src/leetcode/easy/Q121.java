package leetcode.easy;

/**
 * Created by chen on 1/1/18.
 */
public class Q121 {
}

class Q121Solution {
    //brute force (TLE)
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int today = 0; today < prices.length - 1; today++) {
            for (int tomorrow = today + 1; tomorrow < prices.length; tomorrow++) {
                if (prices[tomorrow] > prices[today]) {
                    max = Math.max(max, prices[tomorrow] - prices[today]);
                }
            }
        }
        return max;
    }

    //bright solution
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int minPrice = prices[0];
        for (int index = 1; index < prices.length; index++) {
            max = Math.max(max, prices[index] - minPrice);
            minPrice = Math.min(minPrice, prices[index]);
        }
        return max;
    }
}