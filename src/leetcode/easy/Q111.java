package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q111 {

}

class Q111Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return 1 + helper(node.right);
        }
        if (node.right == null) {
            return 1 + helper(node.left);
        }
        return 1 + Math.min(helper(node.left), helper(node.right));
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.offer(root);
        int level = 0;
        while (!currLevel.isEmpty()) {
            level++;
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
            currLevel = nextLevel;
        }
        return level;
    }
}
