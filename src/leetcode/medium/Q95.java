package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cchen on 1/11/18.
 */
public class Q95 {
}

class Q95Solution {
    //divide and conquer
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int root = left; root <= right; root++) {
            List<TreeNode> leftSubtrees = helper(left, root - 1), rightSubtrees = helper(root + 1, right);
            for (TreeNode leftNode : leftSubtrees) {
                for (TreeNode rightNode : rightSubtrees) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    res.add(rootNode);
                }
            }
        }
        return res;
    }
}