package leetcode.easy;

public class Q110 {
}

class Q110Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private Res helper(TreeNode node) {
        if (node == null) {
            return new Res(0, true);
        }
        Res leftRes = helper(node.left), rightRes = helper(node.right);
        if (!leftRes.isBalanced || !rightRes.isBalanced || Math.abs(leftRes.height - rightRes.height) > 1) {
            return new Res(-1, false);
        }
        return new Res(Math.max(leftRes.height, rightRes.height), true);
    }

    class Res {
        int height;
        boolean isBalanced;
        public Res(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
