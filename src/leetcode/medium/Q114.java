package leetcode.medium;

import java.util.Stack;

public class Q114 {
}

class Q114Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.left == null) {
                if (root.right == null) {
                    if (!stack.isEmpty()) {
                        root.right = stack.pop();
                    }
                }
                root = root.right;
            } else {
                if (root.right != null) {
                    stack.push(root.right);
                }
                root.right = root.left;
                root.left = null;
            }
        }
    }
}