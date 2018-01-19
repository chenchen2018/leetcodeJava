package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {
}

class Q144Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    return list;
                } else {
                    root = stack.pop();
                }
            }
        }
        return list;
    }
}