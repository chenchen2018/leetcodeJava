package leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

//["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
//        [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

public class Q460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);        //2
        cache.put(1, 1);        //1 -> 2
        cache.get(2);           //2 -> 1
        cache.get(1);           //1 -> 2
        cache.get(2);           //2 -> 1
        cache.put(3, 3);        //3 -> 2 -> 1
        cache.put(4, 4);        //4 -> 3 -> 2
        cache.get(3);           //3 -> 4 -> 2
        cache.get(2);           //2 -> 3 -> 4
        cache.get(1);           //-1
        cache.get(4);           //4 -> 2
    }
}

class LFUCache {
    Map<Integer, Integer> values;
    Map<Integer, Integer> frequencies;
    Map<Integer, LinkedHashSet<Integer>> map;
    int capacity;
    int minFrequency;

    public LFUCache(int capacity) {
        values = new HashMap<>();
        frequencies = new HashMap<>();
        map = new HashMap<>();
        this.capacity = capacity;
        minFrequency = -1;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        int currFrequency = frequencies.get(key);
        frequencies.put(key, currFrequency + 1);
        map.get(currFrequency).remove(key);
        if (!map.containsKey(currFrequency + 1)) {
            map.put(currFrequency + 1, new LinkedHashSet<Integer>());
        }
        map.get(currFrequency + 1).add(key);
        if (currFrequency == minFrequency && map.get(currFrequency).isEmpty()) {
            minFrequency++;
        }
        return values.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity < 1) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }
        if (values.size() == capacity) {
            int delete = map.get(minFrequency).iterator().next();
            map.get(minFrequency).remove(delete);
            values.remove(delete);
            frequencies.remove(delete);
        }
        values.put(key, value);
        frequencies.put(key, 1);
        if (!map.containsKey(1)) {
            map.put(1, new LinkedHashSet<>());
        }
        map.get(1).add(key);
        minFrequency = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
