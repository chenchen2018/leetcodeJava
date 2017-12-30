package leetcode.easy;

import java.util.LinkedList;

/**
 * Created by chen on 12/30/17.
 */
public class Q101 {
}

class Q101Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetirc2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> leftTree = new LinkedList<>(), rightTree = new LinkedList<>();
        if (root.left != null) {
            leftTree.offer(root.left);
        }
        if (root.right != null) {
            rightTree.offer(root.right);
        }
        while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
            TreeNode leftNode = leftTree.poll(), rightNode = rightTree.poll();
            if (leftNode.val != rightNode.val) {
                return false;
            }
            if (leftNode.left == null) {
                if (rightNode.right != null) {
                    return false;
                }
            } else {
                if (rightNode.right == null) {
                    return false;
                }
                leftTree.offer(leftNode.left);
                rightTree.offer(rightNode.right);
            }
            if (leftNode.right == null) {
                if (rightNode.left != null) {
                    return false;
                }
            } else {
                if (rightNode.left == null) {
                    return false;
                }
                leftTree.offer(leftNode.right);
                rightTree.offer(rightNode.left);
            }
        }
        return leftTree.isEmpty() && rightTree.isEmpty();
    }
}