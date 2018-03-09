package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496 {
}

class Q496Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreat = new HashMap<>();
        constructNextGreatMap(nextGreat, nums2);
        int[] res = new int[nums1.length];
        for (int index = 0; index < nums1.length; index++) {
            res[index] = nextGreat.getOrDefault(nums1[index], -1);
        }
        return res;
    }

    private void constructNextGreatMap(Map<Integer, Integer> map, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty() || num < stack.peek()) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() < num) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }
    }
}