package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q138 {
}

class Q138Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head, prev = null;
        while (node != null) {
            RandomListNode copyNode = new RandomListNode(node.label);
            if (prev != null) {
                prev.next = copyNode;
            }
            prev = copyNode;
            map.put(node, copyNode);
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int label) {
        this.label = label;
    }
}