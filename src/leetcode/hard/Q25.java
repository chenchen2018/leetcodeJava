package leetcode.hard;

/**
 * Created by chen on 12/28/17.
 */
public class Q25 {
}

class Q25Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor != null) {
            ListNode front = cursor;
            int count = 0;
            while (count < k) {
                front = front.next;
                if (front == null) {
                    return dummy.next;
                }
                count++;
            }
            ListNode next = front.next, tail = cursor.next;
            front.next = null;
            cursor.next = reverse(tail);
            tail.next = next;
            cursor = tail;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        while (node != null) {
            ListNode next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
}