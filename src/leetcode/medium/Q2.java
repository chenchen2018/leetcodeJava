package leetcode.medium;

public class Q2 {
}

class Q2Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cursor = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(carry % 10);
            carry /= 10;
            cursor = cursor.next;
        }
        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }
        return dummy.next;
    }

    //this solution is without creating new list, but using the existing longest one
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int l1Length = getLength(l1), l2Length = getLength(l2);
        ListNode newHead = l1Length >= l2Length ? l1 : l2;
        ListNode dummy = new ListNode(0);
        dummy.next = newHead;
        ListNode cursor = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            newHead.val = carry % 10;
            carry /= 10;
            newHead = newHead.next;
            cursor = cursor.next;
        }
        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }
        return dummy.next;
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

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}