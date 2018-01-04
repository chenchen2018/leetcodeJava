package leetcode.easy;

/**
 * Created by chen on 1/4/18.
 */
public class Q169 {
}

class Q169Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0], counter = 1;
        for (int index = 1; index < nums.length; index++) {
            if (curr == nums[index]) {
                counter++;
            } else {
                counter--;
                if (counter == 0) {
                    curr = nums[index];
                    counter = 1;
                }
            }
        }
        return curr;
    }
}