package leetcode.medium;

/**
 * Created by cchen on 1/27/18.
 */
public class Q300 {
    public static void main(String[] args) {
        Q300Solution solution = new Q300Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        solution.lengthOfLIS2(nums);
    }
}

class Q300Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n + 1];
        int index = 2; //index: to fill up
        //f[i]: i stands for the length of LIS, f[i] stands for the smallest num which has this length
        f[1] = nums[0];
        for (int i = 1; i < n; i++) {
            int position = findPosition(f, 1, index - 1, nums[i]);
            if (position == 0) {
                f[1] = nums[i];
                continue;
            }
            if (position == index - 1) {
                index++;
            }
            f[position + 1] = nums[i];
        }
        return index - 1;
    }

    //find the last number which is smaller than target
    private int findPosition(int[] nums, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] < target) {
            return right;
        }
        if (nums[left] < target) {
            return left;
        }
        return left - 1;
    }

}