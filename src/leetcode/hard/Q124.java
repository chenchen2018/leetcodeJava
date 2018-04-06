package leetcode.hard;

public class Q124 {
}

class Q124Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left), right = helper(node.right);
        max = Math.max(max, node.val + left + right);
        return Math.max(0, Math.max(node.val, node.val + Math.max(left, right)));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}