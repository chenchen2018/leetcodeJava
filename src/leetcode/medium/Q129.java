package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q129 {
}

class Q129Solution {
    // first use dfs to collect all the numbers
    // add them
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> allNumbers = new ArrayList<>();
        helper(allNumbers, root, 0);
        return allNumbers.stream().mapToInt(i -> i).sum();
    }

    private void helper(List<Integer> allNumbers, TreeNode node, int curr) {
        int number = curr * 10 + node.val;
        if (node.left == null && node.right == null) {
            allNumbers.add(number);
            return;
        }
        if (node.left != null) {
            helper(allNumbers, node.left, number);
        }
        if (node.right != null) {
            helper(allNumbers, node.right, number);
        }
    }
}