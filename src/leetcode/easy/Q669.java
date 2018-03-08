package leetcode.easy;

public class Q669 {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        three.left = one;
        three.right = four;
        one.right = two;
        new Q669Solution().trimBST(three, 1, 2);
    }
}

class Q669Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        TreeNode leftChild = trimBST(root.left, L, R), rightChild = trimBST(root.right, L, R);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
