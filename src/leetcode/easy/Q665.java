package leetcode.easy;

/**
 * Created by cchen on 3/11/18.
 */
public class Q665 {
}

class Q665Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int position = -1, counter = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] < nums[index - 1]) {
                counter++;
                position = index;
            }
        }
        if (counter == 0) {
            return true;
        }
        if (counter > 1) {
            return false;
        }
        if (position == 0 || position == nums.length - 1 || nums[position - 1] <= nums[position + 1] || nums[position - 2] <= nums[position]) {
            return true;
        }
        return false;
    }
}
