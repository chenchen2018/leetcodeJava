package leetcode.medium;

public class Q142 {
}

class Q142Solution {
    public ListNode detectCycle(ListNode head) {
        //first let's see if there is a cycle in it.
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        while (head != slow.next) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}