package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q219 {
}

class Q219Solution {
    //TLE brute force solution
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int index = 0; index < nums.length; index++) {
            int front = index + 1;
            while (front < nums.length && front <= index + k) {
                if (nums[index] == nums[front]) {
                    return true;
                }
                front++;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                if (index - map.get(nums[index]) <= k) {
                    return true;
                }
            }
            map.put(nums[index], index);
        }
        return false;
    }
}