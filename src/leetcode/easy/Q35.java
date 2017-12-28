package leetcode.easy;

/**
 * Created by chen on 12/28/17.
 */
public class Q35 {

}

class Q35Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target > nums[right]) {
            return right + 1;
        } else if (target <= nums[left]) {
            return left;
        } else {
            return right;
        }
    }
}