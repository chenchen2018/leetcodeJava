package leetcode.medium;

/**
 * Created by chen on 1/5/18.
 */
public class Q75 {
}

class Q75Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int redIndex = -1, whiteIndex = -1, blueIndex = -1;
        for (int num : nums) {
            if (num == 0) {
                nums[++blueIndex] = 2;
                nums[++whiteIndex] = 1;
                nums[++redIndex] = 0;
            } else if (num == 1) {
                nums[++blueIndex] = 2;
                nums[++whiteIndex] = 1;
            } else {
                nums[++blueIndex] = 2;
            }
        }
    }
}