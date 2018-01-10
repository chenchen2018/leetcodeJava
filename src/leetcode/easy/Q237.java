package leetcode.easy;

public class Q237 {
}

class Q237Solution {
    public void deleteNode(ListNode node) {
        while (node.next != null && node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}