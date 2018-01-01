package leetcode.easy;

/**
 * Created by chen on 1/1/18.
 */
public class Q136 {
}

class Q136Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}