package leetcode.medium;

import java.util.Arrays;

public class Q16 {
}

class Q16Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        int gap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0;
        while (left < nums.length - 2) {
            int mid = left + 1, right = nums.length - 1;
            int wanted = target - nums[left];
            while (mid < right) {
                int temp = nums[mid] + nums[right];
                if (temp == wanted) {
                    return target;
                } else {
                    if (Math.abs(temp - wanted) < Math.abs(gap)) {
                        gap = temp - wanted;
                    }
                    if (temp < wanted) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
            left++;
        }
        return target + gap;
    }
}