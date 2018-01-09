package leetcode.medium;

public class Q86 {
}

class Q86Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallDummy = new ListNode(0), smallCurosr = smallDummy;
        ListNode largeDummy = new ListNode(0), largeCursor = largeDummy;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                smallCurosr.next = head;
                smallCurosr = smallCurosr.next;
            } else {
                largeCursor.next = head;
                largeCursor = largeCursor.next;
            }
            head = next;
        }
        largeCursor.next = null;
        smallCurosr.next = largeDummy.next;
        return smallDummy.next;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), small = dummy, large = dummy;
        dummy.next = head;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                if (small == large) {
                    small.next = head;
                    small = small.next;
                    large = large.next;
                } else {
                    ListNode smallNext = small.next;
                    small.next = head;
                    head.next = smallNext;
                    small = head;
                    large.next = next;
                }
            } else {
                large.next = head;
                large = large.next;
            }
            head = next;
        }
        return dummy.next;
    }
}