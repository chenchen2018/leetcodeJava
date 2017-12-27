package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q15 {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        set.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1); list2.add(2);
        System.out.println(set.contains(list2));
        System.out.println(list1.equals(list2));
        System.out.println(list1 == list2);
    }
}

class Q15Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int left = 0;
        while (left < nums.length - 2) {
            int mid = left + 1, right = nums.length - 1;
            int target = -nums[left];
            while (mid < right) {
                int temp = nums[mid] + nums[right];
                if (temp < target) {
                    mid++;
                } else if (temp > target) {
                    right--;
                } else {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[left]);
                    curr.add(nums[mid]);
                    curr.add(nums[right]);
                    res.add(curr);
                    mid++;
                    while (mid < right && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                    right--;
                    while (mid < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            left++;
            while (left < nums.length - 2 && nums[left] == nums[left - 1]) {
                left++;
            }
        }
        return res;
    }
}
