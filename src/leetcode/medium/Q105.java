package leetcode.medium;

/**
 * Created by cchen on 1/16/18.
 */
public class Q105 {
}

class Q105Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootIndex = findRootIndex(inorder, inLeft, inRight, preorder[preLeft]);
        root.left = helper(preorder, preLeft + 1, preLeft + inRootIndex - inLeft, inorder, inLeft, inRootIndex - 1);
        root.right = helper(preorder, preRight - (inRight - inRootIndex) + 1, preRight, inorder, inRootIndex + 1, inRight);
        return root;
    }

    private int findRootIndex(int[] array, int left, int right, int target) {
        while (left <= right) {
            if (array[left] == target) {
                return left;
            }
            left++;
        }
        return -1;
    }
}