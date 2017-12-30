package leetcode.easy;

/**
 * Created by chen on 12/30/17.
 */
public class Q104 {
}

class Q104Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}