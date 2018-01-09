package leetcode.hard;

import java.util.Arrays;

/**
 * Created by chen on 1/8/18.
 */
public class Q45 {
}

class Q45Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int index = 0; index < nums.length; index++) {
            int stepsToMove = nums[index], step = 1;
            while (index + step < nums.length && step <= stepsToMove) {
                dp[index + step] = Math.min(dp[index + step], dp[index] + 1);
                step++;
            }
        }
        return dp[dp.length - 1];
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxToJump = nums[0], jumps = 1;
        for (int index = 1; index < nums.length; index++) {
            maxToJump--;
            if (maxToJump < nums[index]) {
                maxToJump = nums[index];
                jumps++;
            }
        }
        return jumps;
    }
}