package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chen on 1/9/18.
 */
public class Q82 {
}

class Q82Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor.next != null && cursor.next.next != null) {
            if (cursor.next.val != cursor.next.next.val) {
                cursor = cursor.next;
            } else {
                int duplicate = cursor.next.val;
                ListNode pointer = cursor.next;
                while (pointer != null && pointer.val == duplicate) {
                    pointer = pointer.next;
                }
                cursor.next = pointer;
            }
        }
        return dummy.next;
    }
}