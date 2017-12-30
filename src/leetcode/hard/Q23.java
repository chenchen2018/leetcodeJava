package leetcode.hard;

import java.util.PriorityQueue;

/**
 * Created by cchen on 12/28/17.
 */
public class Q23 {
}

class Q23Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cursor = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
           return n1.val - n2.val;
        });
        //first load the head into pq
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        //sort
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cursor.next = node;
            cursor = cursor.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
