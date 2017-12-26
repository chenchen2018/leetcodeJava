package leetcode.medium;

public class Q106 {

}

class Q106Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootValue = postorder[postRight];
        int rootIndex = findTarget(inorder, rootValue, inLeft, inRight);
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(inorder, inLeft, rootIndex - 1, postorder, postLeft, postLeft + rootIndex - inLeft - 1);
        root.right = helper(inorder, rootIndex + 1, inRight, postorder, postLeft + rootIndex - inLeft, postRight - 1);
        return root;
    }

    private int findTarget(int[] array, int target, int left, int right) {
        while (left <= right) {
            if (array[left] == target) {
                return left;
            }
            left++;
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}