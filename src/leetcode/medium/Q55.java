package leetcode.medium;

/**
 * Created by chen on 1/1/18.
 */
public class Q55 {
}

class Q55Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int maxSteps = nums[0];
        int index = 1;
        while (index < nums.length) {
            maxSteps--;
            if (maxSteps < 0) {
                return false;
            }
            maxSteps = Math.max(maxSteps, nums[index]);
            index++;
        }
        return true;
    }

    //dp solution(TLE)
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for (int index = 0; index < nums.length; index++) {
            if (canJump[index] == false) {
                return false;
            }
            int steps = 1;
            while (steps <= nums[index] && index + steps < nums.length) {
                canJump[index + steps] = true;
                steps++;
            }
        }
        return canJump[canJump.length - 1];
    }
}