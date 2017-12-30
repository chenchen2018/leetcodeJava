package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chen on 12/30/17.
 */
public class Q100 {
}

class Q100Solution {
    //first version: recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> leftTree = new LinkedList<>(), rightTree = new LinkedList<>();
        if (p != null) {
            leftTree.offer(p);
        }
        if (q != null) {
            rightTree.offer(q);
        }
        while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
            TreeNode leftNode = leftTree.poll(), rightNode = rightTree.poll();
            if (leftNode.val != rightNode.val) {
                return false;
            }
            if (leftNode.left == null) {
                if (rightNode.left != null) {
                    return false;
                }
            } else {
                if (rightNode.left == null) {
                    return false;
                }
                leftTree.offer(leftNode.left);
                rightTree.offer(rightNode.left);
            }
            if (leftNode.right == null) {
                if (rightNode.right != null) {
                    return false;
                }
            } else {
                if (rightNode.right == null) {
                    return false;
                }
                leftTree.offer(leftNode.right);
                rightTree.offer(rightNode.right);
            }
        }
        return leftTree.isEmpty() && rightTree.isEmpty();
    }
}