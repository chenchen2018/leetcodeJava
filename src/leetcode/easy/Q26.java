package leetcode.easy;

public class Q26 {
}

class Q26Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cursor = 1;
        for (int front = 1; front < nums.length; front++) {
            if (nums[front] != nums[front - 1]) {
                nums[cursor++] = nums[front];
            }
        }
        return cursor;
    }
}