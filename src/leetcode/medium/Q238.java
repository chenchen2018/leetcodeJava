package leetcode.medium;

/**
 * Created by chen on 3/31/18.
 */
public class Q238 {
}

class Q238Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int index = nums.length - 2; index >= 0; index--) {
            right *= nums[index + 1];
            res[index] *= right;
        }
        return res;
    }
}
