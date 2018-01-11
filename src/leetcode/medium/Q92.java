package leetcode.medium;

public class Q92 {
}

class Q92Solution {
    //    Reverse a linked list from position m to n. Do it in-place and in one-pass.
    //
    //    For example:
    //    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    //
    //return 1->4->3->2->5->NULL.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //here assuming all the inputs are valid
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        int step = 0;
        while (step <= n  - m) {
            fast = fast.next;
            step++;
        }
        step = 1;
        while (step < m) {
            slow = slow.next;
            fast = fast.next;
            step++;
        }
        ListNode slowNext = slow.next, fastNext = fast.next;
        fast.next = null;
        slow.next = reverse(slowNext);
        slowNext.next = fastNext;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}