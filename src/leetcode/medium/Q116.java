package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q116 {
}

class Q116Solution{
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        helper(root.left, root.right);
    }

    private void helper(TreeLinkNode left, TreeLinkNode right) {
        if (left == null) {
            return;
        }
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }

    public void connect2(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        TreeLinkNode parent = root, next = root.left;   //next is pointing to the first node on next level
        while (parent != null && next != null) {
            TreeLinkNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
                if (parent != null) {
                    prev.next = parent.left;
                    prev = prev.next;
                }
            }
            parent = next;
            next = parent.left;
        }
    }

    public void connect3(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        Queue<TreeLinkNode> currLevel = new LinkedList<>();
        Queue<TreeLinkNode> nextLevel;
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            nextLevel = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                TreeLinkNode node = currLevel.poll();
                if (!currLevel.isEmpty()) {
                    node.next = currLevel.peek();
                }
                if (node.left != null) {
                    nextLevel.offer(node.left);
                    nextLevel.offer(node.right);
                }
            }
            currLevel = nextLevel;
        }
    }
}

class TreeLinkNode {
    TreeLinkNode left, right, next;
    int val;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
