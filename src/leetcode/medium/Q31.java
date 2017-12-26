package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Q31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        new Q31Solution().nextPermutation3(nums);
        IntStream.of(nums).forEach(System.out::println);
    }
}

class Q31Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int index = nums.length - 1; index >= 0; index--) {
            int targetIndex = -1, targetNumner = Integer.MAX_VALUE;
            for (int scan = index + 1; scan < nums.length; scan++) {
                if (nums[index] < nums[scan]) {
                    if (targetIndex == -1 || nums[scan] < targetNumner) {
                        targetIndex = scan;
                        targetNumner = nums[scan];
                    }
                }
            }
            if (targetIndex != -1) {
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
                Arrays.sort(nums, index + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public void nextPermutation2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        for (int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] >= stack.peek()) {
                stack.push(nums[index]);
            } else {
                int targetIndex = index;
                while (!stack.isEmpty() && nums[index] < stack.peek()) {
                    stack.pop();
                    targetIndex++;
                }
                int temp = nums[index];
                nums[index] = nums[targetIndex];
                nums[targetIndex] = temp;
                Arrays.sort(nums, index + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public void nextPermutation3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] >= nums[index + 1]) {
                continue;
            }
            int targetIndex = index + 1, smallestTarget = nums[targetIndex];
            for (int cursor = targetIndex + 1; cursor < nums.length; cursor++) {
                if (nums[cursor] > nums[index] && smallestTarget > nums[cursor]) {
                    smallestTarget = nums[cursor];
                    targetIndex = cursor;
                }
            }
            nums[targetIndex] = nums[index];
            nums[index] = smallestTarget;
            Arrays.sort(nums, index + 1, nums.length);
            return;
        }
        Arrays.sort(nums);
    }
}
