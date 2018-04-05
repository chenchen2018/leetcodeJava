package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q173 {
}

class BSTIterator {
    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        helper(root);
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}

class BSTIterator2 {
    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop(), node = result.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return result.val;
    }
}
