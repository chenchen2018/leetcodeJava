package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
}

class Q257Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add("" + root.val);
            return res;
        }
        String prefix = "" + root.val;
        List<String> leftPaths = binaryTreePaths(root.left), rightPaths = binaryTreePaths(root.right);
        for (String leftPath : leftPaths) {
            res.add(prefix + "->" + leftPath);
        }
        for (String rightPath : rightPaths) {
            res.add(prefix + "->" + rightPath);
        }
        return res;
    }
}