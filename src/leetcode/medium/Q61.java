package leetcode.medium;

/**
 * Created by chen on 1/4/18.
 */
public class Q61 {
}

class Q61Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = getLength(head);
        k %= length;
        if (k == 0) {
            return head;
        }
        ListNode cursor = head;
        int step = 0;
        while (step < length - 1 - k) {
            cursor = cursor.next;
            step++;
        }
        ListNode next = cursor.next, newHead = cursor.next;
        cursor.next = null;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}