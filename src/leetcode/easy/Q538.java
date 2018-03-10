package leetcode.easy;

import java.util.*;

/**
 * Created by cchen on 3/10/18.
 */
public class Q538 {
}

class Q538Solution {
    public TreeNode convertBSTCumbersome(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        Map<Integer, Integer> map = new HashMap<>();
        int carry = 0;
        for (int index = list.size() - 1; index >= 0; index--) {
            map.put(list.get(index), carry);
            carry += list.get(index);
        }
        convert(root, map);
        return root;
    }

    private void convert(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        convert(node.left, map);
        convert(node.right, map);
        node.val += map.get(node.val);
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBSTIteration(TreeNode root) {
        if (root == null) {
            return root;
        }
        int sum = 0;
        TreeNode res = root;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;
            if (node.left != null) {
                node = node.left;
                while (node != null) {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return res;
    }
}
