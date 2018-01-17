package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
}

class Q113Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, TreeNode node, int target) {
        //exit condition
        if (node.left == null && node.right == null && node.val == target) {
            curr.add(node.val);
            res.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        curr.add(node.val);
        if (node.left != null) {
            helper(res, curr, node.left, target - node.val);
        }
        if (node.right != null) {
            helper(res, curr, node.right, target - node.val);
        }
        curr.remove(curr.size() - 1);
    }
}