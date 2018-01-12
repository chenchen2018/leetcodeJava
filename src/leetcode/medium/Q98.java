package leetcode.medium;

/**
 * Created by cchen on 1/11/18.
 */
public class Q98 {
}

class Q98Solution {
    public boolean isValidBST2(TreeNode root) {
        return helper2(root, null, null);
    }

    //min and max are exclusive
    private boolean helper2(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null) {
            if (node.val <= min) {
                return false;
            }
        }
        if (max != null) {
            if (node.val >= max) {
                return false;
            }
        }
        return helper2(node.left, min, node.val) && helper2(node.right, node.val, max);
    }

    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null) {
            if (root.val <= prev.val) {
                return false;
            }
        }
        prev = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}