package leetcode.medium;

/**
 * Created by cchen on 1/26/18.
 */
public class Q213 {
}

class Q213Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    //indexs are inclusive
    private int helper(int[] nums, int start, int end) {
        int[] f = new int[nums.length + 1];
        f[start + 1] = nums[start];
        f[start + 2] = Math.max(nums[start], nums[start + 1]);
        for (int house = start + 3; house <= end + 1; house++) {
            f[house] = Math.max(f[house - 1], f[house - 2] + nums[house - 1]);
        }
        return f[end + 1];
    }
}