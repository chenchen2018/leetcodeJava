package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cchen on 3/6/18.
 */
public class Q617 {
}

class Q617Solution {
    public TreeNode mergeTreesRecursion(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTreesRecursion(t1.left, t2.left);
        newNode.right = mergeTreesRecursion(t1.right, t2.right);
        return newNode;
    }

    public TreeNode mergeTreesIteration(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        Queue<TreeNode> left = new LinkedList<>(), right = new LinkedList<>();
        left.offer(t1);
        right.offer(t2);
        while (!left.isEmpty()) {
            TreeNode leftNode = left.poll(), rightNode = right.poll();
            if (leftNode.left == null) {
                if (rightNode.left != null) {
                    leftNode.left = rightNode.left;
                }
            } else {
                if (rightNode.left != null) {
                    leftNode.left.val += rightNode.left.val;
                    left.offer(leftNode.left);
                    right.offer(rightNode.left);
                }
            }
            if (leftNode.right == null) {
                if (rightNode.right != null) {
                    leftNode.right = rightNode.right;
                }
            } else {
                if (rightNode.right != null) {
                    leftNode.right.val += rightNode.right.val;
                    left.offer(leftNode.right);
                    right.offer(rightNode.right);
                }
            }
        }
        return t1;
    }
}
