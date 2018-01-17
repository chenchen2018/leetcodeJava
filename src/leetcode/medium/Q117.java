package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q117 {
}

class Q117Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
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
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
            currLevel = nextLevel;
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode parent = root, prev, next;
        while (parent != null) {
            prev = null;
            next = null;
            while (parent != null) {
                if (next == null) {
                    next = parent.left != null ? parent.left : parent.right;
                }
                if (parent.left != null) {
                    if (prev == null) {
                        prev = parent.left;
                    } else {
                        prev.next = parent.left;
                        prev = prev.next;
                    }
                }
                if (parent.right != null) {
                    if (prev == null) {
                        prev = parent.right;
                    } else {
                        prev.next = parent.right;
                        prev = prev.next;
                    }
                }
                parent = parent.next;
            }
        }
    }
}