package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q217 {
}

class Q217Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                return true;
            }
        }
        return false;
    }
}