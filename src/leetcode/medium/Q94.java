package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {
}

class Q94Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            TreeNode rightNode = node.right;
            while (rightNode != null) {
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return res;
    }
}
