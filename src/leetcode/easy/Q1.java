package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
}

class Q1Solution {
    //brute force solution
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length < 2) {
            return res;
        }
        for (int left = 0; left < nums.length - 1; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[left] + nums[right] == target) {
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
            }
        }
        return res;
    }

    //HashMap solution. Time complexity is:
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                res[0] = map.get(target - nums[index]);
                res[1] = index;
                return res;
            }
            map.put(nums[index], index);
        }
        return res;
    }
}