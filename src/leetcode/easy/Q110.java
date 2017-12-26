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
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
