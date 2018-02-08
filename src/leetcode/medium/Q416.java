package leetcode.medium;

public class Q416 {
}

class Q416Solution {
    //dfs way, but TLE as you can imagine
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        return helper(nums, 0, 0, 0);
    }

    private boolean helper(int[] nums, int basket1, int basket2, int index) {
        if (index == nums.length) {
            return basket1 == basket2;
        }
        return helper(nums, basket1 + nums[index], basket2, index + 1) ||
                helper(nums, basket1, basket2 + nums[index], index + 1);
    }

    //dp way?
    public boolean canPartition2(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

    }
}