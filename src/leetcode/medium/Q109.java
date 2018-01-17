package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchen on 1/16/18.
 */
public class Q109 {
}

class Q109Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return constructTree(list, 0, list.size() - 1);
    }

    private TreeNode constructTree(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = constructTree(nums, left, mid - 1);
        root.right = constructTree(nums, mid + 1, right);
        return root;
    }
}