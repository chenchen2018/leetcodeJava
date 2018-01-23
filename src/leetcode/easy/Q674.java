package leetcode.easy;

/**
 * Created by cchen on 1/22/18.
 */
public class Q674 {
}

class Q674Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int[] f = new int[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            f[i] = 1;
            if (i > 0 && nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
            }
            res = Math.max(f[i], res);
        }

        return res;
    }
}