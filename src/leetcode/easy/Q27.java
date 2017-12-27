package leetcode.easy;

public class Q27 {
}

class Q27Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cursor = 0;
        for (int front = 0; front < nums.length; front++) {
            if (nums[front] != val) {
                nums[cursor++] = nums[front];
            }
        }
        return cursor;
    }
}