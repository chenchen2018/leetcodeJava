package leetcode.medium;

import java.util.*;

/**
 * Created by cchen on 1/16/18.
 */
public class Q103 {
}

class Q103Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        currLevel.push(root);
        boolean leftToRight = true;
        while (!currLevel.isEmpty()) {
            Stack<TreeNode> nextLevel = new Stack<>();
            List<Integer> values = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                values.add(node.val);
                if (leftToRight) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            leftToRight = leftToRight ? false : true;
            res.add(values);
            currLevel = nextLevel;
        }
        return res;
    }

}