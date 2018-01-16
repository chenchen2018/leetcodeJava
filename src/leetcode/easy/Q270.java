package leetcode.easy;

public class Q270 {
}

class Q270Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(target - root.val) < Math.abs(target - closest) ? root.val : closest;
            if (root.val == target) {
                return root.val;
            } else if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closest;
    }
}