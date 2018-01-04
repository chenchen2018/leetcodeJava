package leetcode.easy;

/**
 * Created by chen on 1/3/18.
 */
public class Q160 {
}

class Q160Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLength(headA), bLength = getLength(headB);
        ListNode longList = aLength >= bLength ? headA : headB;
        ListNode shortList = aLength < bLength ? headA : headB;
        int step = 0;
        while (step < Math.abs(aLength - bLength)) {
            longList = longList.next;
            step++;
        }
        while (shortList != null) {
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;
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
