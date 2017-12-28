package leetcode.medium;

/**
 * Created by chen on 12/28/17.
 */
public class Q24 {
}

class Q24Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode first = cursor.next, second = first.next, next = second.next;
            cursor.next = second;
            second.next = first;
            first.next = next;
            cursor = first;
        }
        return dummy.next;
    }
}