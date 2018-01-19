package leetcode.medium;

public class Q147 {
}

class Q147Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode newHead = head.next;
            head.next = node.next;
            node.next = head;
            head = newHead;
        }
        return dummy.next;
    }
}