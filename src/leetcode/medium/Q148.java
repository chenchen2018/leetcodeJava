package leetcode.medium;

public class Q148 {
}

class Q148Solution {
    //O(nlng) time complexity. so let's do a merge sort.
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        ListNode newHead = head;
        int count = 1;
        while (count < length / 2) {
            newHead = newHead.next;
            count++;
        }
        ListNode tail = newHead;
        newHead = newHead.next;
        tail.next = null;
        head = sortList(head);
        newHead = sortList(newHead);
        ListNode dummy = new ListNode(0), cursor = dummy;
        while (head != null && newHead != null) {
            if (head.val <= newHead.val) {
                cursor.next = head;
                head = head.next;
            } else {
                cursor.next = newHead;
                newHead = newHead.next;
            }
            cursor = cursor.next;
        }
        cursor.next = (head == null ? newHead : head);
        return dummy.next;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}