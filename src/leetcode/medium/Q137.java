package leetcode.medium;

public class Q137 {
    public static void main(String[] args) {
        int[] nums = {2 ,2, 3, 2};
        new Q137Solution().singleNumber(nums);
    }
}

class Q137Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] bitCounts = new int[32];
        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                bitCounts[bit] += ((num >> bit) & 1);
                bitCounts[bit] %= 3;
            }
        }
        int res = 0;
        for (int index = 31; index >= 0; index--) {
            res = ((res << 1) | bitCounts[index]);
        }
        return res;
    }
}