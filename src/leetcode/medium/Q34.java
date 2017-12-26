package leetcode.medium;

public class Q34 {
}

class Q34Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == target) {
                if (res[0] == -1) {
                    res[0] = index;
                }
                res[1] = index;
            }
        }
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);
        return res;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return nums[right] == target ? right : -1;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return nums[left] == target ? left : -1;
    }
}