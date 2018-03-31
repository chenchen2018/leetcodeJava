package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/31/18.
 */
public class Q513 {
}

class Q513Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res.get(res.size() - 1);
    }

    private void helper(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (level > res.size()) {
            res.add(node.val);
        }
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }
}
