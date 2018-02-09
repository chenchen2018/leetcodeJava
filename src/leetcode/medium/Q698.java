package leetcode.medium;

import java.util.Arrays;

public class Q698 {
}

class Q698Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        int endIndex = nums.length - 1;
        if (nums[endIndex] > target) {
            return false;
        }
        while (endIndex >= 0 && nums[endIndex] == target) {
            k--;
            endIndex--;
        }
        return helper(nums, endIndex, new int[k], target);
    }

    private boolean helper(int[] nums, int endIndex, int[] buckets, int target) {
        if (endIndex < 0) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[endIndex] <= target) {
                buckets[i] += nums[endIndex];
                if (helper(nums, endIndex - 1, buckets, target)) {
                    return true;
                }
                buckets[i] -= nums[endIndex];
            }
        }
        return false;
    }
}