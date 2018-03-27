package leetcode.medium;

/**
 * Created by cchen on 3/27/18.
 */
public class Q285 {
}

class Q285Solution {
    TreeNode next, prev;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        next = null;
        prev = null;
        helper(root, p);
        return next;
    }

    private void helper(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }
        helper(node.left, p);
        if (prev != null) {
            if (prev == p) {
                next = node;
            }
        }
        prev = node;
        helper(node.right, p);
    }
}

class Q285Solution2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        if (root == null) {
            return root;
        }
        if (p.right == null) {
            return successor;
        }
        p = p.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
