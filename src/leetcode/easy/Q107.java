package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chen on 12/30/17.
 */
public class Q107 {
}

class Q107Solution {
    //first dfs solution
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        helper(res, node.left, depth + 1);
        helper(res, node.right, depth + 1);
        res.get(res.size() - 1 - depth).add(node.val);
    }

    //second bfs solution
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> currLevel = new LinkedList<>();
        if (root != null) {
            currLevel.add(root);
        }
        while (!currLevel.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> currNums = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.poll();
                currNums.add(node.val);
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
            res.add(0, currNums);
            currLevel = nextLevel;
        }
        return res;
    }
}
