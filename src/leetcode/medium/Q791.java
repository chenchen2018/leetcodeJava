package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cchen on 2/27/18.
 */
public class Q791 {
}

class Q791Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> order = new HashMap<>();
        for (int index = 0; index < S.length(); index++) {
            order.put(S.charAt(index), index);
        }
        TreeMap<Character, Integer> map = new TreeMap<>((c1, c2) -> {
            if (order.containsKey(c1) && order.containsKey(c2)) {
                return order.get(c1) - order.get(c2);
            } else if (order.containsKey(c1)) {
                return -1;
            } else if (order.containsKey(c2)) {
                return 1;
            } else {
                return c1 - c2;
            }
        });
        for (char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : map.keySet()) {
            int repeat = map.get(c);
            while (repeat > 0) {
                sb.append(c);
                repeat--;
            }
        }
        return sb.toString();
    }
}