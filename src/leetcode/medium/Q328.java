package leetcode.medium;

public class Q328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1), two = new ListNode(2), three = new ListNode(3);
        head.next = two;
        two.next = three;
        new Q328Solution().oddEvenList(head);
    }
}

class Q328Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(0), dummyEven = new ListNode(0);
        int counter = 0;
        ListNode oddCursor = dummyOdd, evenCursor = dummyEven;
        while (head != null) {
            counter++;
            if (counter % 2 == 0) {
                evenCursor.next = head;
                evenCursor = evenCursor.next;
            } else {
                oddCursor.next = head;
                oddCursor = oddCursor.next;
            }
            head = head.next;
        }
        evenCursor.next = null;
        oddCursor.next = dummyEven.next;
        return dummyOdd.next;
    }
}