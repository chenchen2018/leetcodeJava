package leetcode.medium;

public class Q416 {
    public static void main(String[] args) {
        int[] input = {1, 2, 5};
        new Q416Solution().canPartition2(input);
    }
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
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                if (f[i - num]) {
                    f[i] = true;
                }
            }
        }
        return f[sum / 2];
    }
}