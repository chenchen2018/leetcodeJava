package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by cchen on 3/5/18.
 */
public class Q760 {
}

class Q760Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int index = 0; index < B.length; index++) {
            if (!map.containsKey(B[index])) {
                map.put(B[index], new LinkedList<Integer>());
            }
            map.get(B[index]).offer(index);
        }
        int[] res = new int[A.length];
        for (int index = 0; index < A.length; index++) {
            res[index] = map.get(A[index]).poll();
        }
        return res;
    }
}