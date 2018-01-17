package leetcode.easy;

public class Q283 {
}

class Q283Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int zeroIndex = -1, forwardIndex = 0;
        while (forwardIndex < nums.length) {
            if (nums[forwardIndex] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = forwardIndex;
                }
            } else {
                if (zeroIndex != -1) {
                    nums[zeroIndex++] = nums[forwardIndex];
                    nums[forwardIndex] = 0;
                }
            }
            forwardIndex++;
        }
    }
}