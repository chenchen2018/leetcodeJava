package leetcode.medium;

public class Q80 {
}

class Q80Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int curr = nums[0], counter = 1;
        int cursor = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != curr) {
                nums[cursor++] = nums[index];
                curr = nums[index];
                counter = 1;
            } else {
                if (counter == 1) {
                    counter = 2;
                    nums[cursor++] = nums[index];
                }
            }
        }
        return cursor;
    }
}