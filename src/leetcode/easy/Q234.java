package leetcode.easy;

import java.util.Stack;

public class Q234 {
}

class Q234Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = getLength(head);
        Stack<ListNode> stack = new Stack<>();
        int curr = 1;
        while (curr <= length / 2) {
            stack.push(head);
            head = head.next;
            curr++;
        }
        if (length % 2 != 0) {
            head = head.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = getLength(head);
        int step = 1;
        ListNode cursor = head;
        while (step < length / 2) {
            step++;
            cursor = cursor.next;
        }
        ListNode newHead = cursor.next;
        cursor.next = null;
        newHead = reverse(newHead);
        while (head != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
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