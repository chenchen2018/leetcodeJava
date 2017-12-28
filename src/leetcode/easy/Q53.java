package leetcode.easy;

/**
 * Created by chen on 12/28/17.
 */
public class Q53 {
}

class Q53Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0], currMax = nums[0];
        for (int index = 1; index < nums.length; index++) {
            currMax = Math.max(currMax + nums[index], nums[index]);
            globalMax = Math.max(globalMax, currMax);
        }
        return globalMax;
    }
}