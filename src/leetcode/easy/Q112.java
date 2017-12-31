package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chen on 12/31/17.
 */
public class Q112 {
}

class Q112Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<Integer> targets = new LinkedList<>();
        currLevel.offer(root);
        targets.add(sum);
        while (!currLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            Queue<Integer> nextLevelTarget = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.poll();
                int target = targets.poll();
                if (node.left == null && node.right == null) {
                    if (node.val == target) {
                        return true;
                    }
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                    nextLevelTarget.add(target - node.val);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                    nextLevelTarget.add(target - node.val);
                }
            }
            currLevel = nextLevel;
            targets = nextLevelTarget;
        }
        return false;
    }
}