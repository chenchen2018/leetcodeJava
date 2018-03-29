package leetcode.medium;

public class Q654 {
}

class Q654Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = findMaximum(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, end);
        return root;
    }

    private int findMaximum(int[] array, int start, int end) { //parameters are inclusive
        int max = array[start], res = start;
        for (int index = start + 1; index <= end; index++) {
            if (array[index] > max) {
                max = array[index];
                res = index;
            }
        }
        return res;
    }
}