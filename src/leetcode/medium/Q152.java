package leetcode.medium;

public class Q152 {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        new Q152Solution().maxProduct(nums);
    }
}

class Q152Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n], min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
            max[i] = Math.max(min[i - 1] * nums[i], Math.max(max[i - 1] * nums[i], max[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], min[i]));
            res = Math.max(res, max[i]);
        }
        return res;
    }
}