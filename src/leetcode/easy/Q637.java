package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637 {
}

class Q637Solution {
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), nums = size;
            double sum = 0.0;
            while (size > 0) {
                size--;
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(sum / nums);
        }
        return res;
    }

    //DFS way
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        helper(lists, root, 0);
        List<Double> res = new ArrayList<>();
        for (List<TreeNode> list : lists) {
            double sum = 0;
            int size = list.size();
            for (TreeNode node: list) {
                sum += node.val;
            }
            res.add(sum / size);
        }
        return res;
    }

    private void helper(List<List<TreeNode>> lists, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= lists.size()) {
            lists.add(new ArrayList<TreeNode>());
        }
        lists.get(depth).add(node);
        helper(lists, node.left, depth + 1);
        helper(lists, node.right, depth + 1);
    }
}
