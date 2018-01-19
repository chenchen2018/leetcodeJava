package leetcode.medium;

public class Q143 {
}

class Q143Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        ListNode dummy = new ListNode(0), cursor = dummy;
        while (head != null && fast != null) {
            cursor.next = head;
            head = head.next;
            cursor = cursor.next;
            cursor.next = fast;
            fast = fast.next;
            cursor = cursor.next;
        }
        if (head != null) {
            cursor.next = head;
        }
        head = dummy.next;
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