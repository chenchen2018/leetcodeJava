package leetcode.medium;

/**
 * Created by chen on 12/28/17.
 */
public class Q33 {
}

class Q33Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > nums[right]) {
            if (nums[left] <= target && target < nums[mid]) {
                return helper(nums, left, mid - 1, target);
            } else {
                return helper(nums, mid + 1, right, target);
            }
        } else {
            if (nums[right] >= target && target > nums[mid]) {
                return helper(nums, mid + 1, right, target);
            } else {
                return helper(nums, left, mid - 1, target);
            }
        }
    }
}