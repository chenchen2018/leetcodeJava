package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q102 {
}

class Q102Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> currLevelNode = new LinkedList<>();
        currLevelNode.add(root);
        while (!currLevelNode.isEmpty()) {
            List<Integer> currLevelNum = new ArrayList<>();
            LinkedList<TreeNode> nextLevelNode = new LinkedList<>();
            while (!currLevelNode.isEmpty()) {
                TreeNode node = currLevelNode.poll();
                currLevelNum.add(node.val);
                if (node.left != null) {
                    nextLevelNode.offer(node.left);
                }
                if (node.right != null) {
                    nextLevelNode.offer(node.right);
                }
            }
            res.add(currLevelNum);
            currLevelNode = nextLevelNode;
        }
        return res;
    }
}