package leetcode.medium;

import java.util.*;

public class Q692 {
}

class Q692Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((e1, e2) -> {
            if (e1.frequency != e2.frequency) {
                return e2.frequency - e1.frequency;
            } else {
                return e1.word.compareTo(e2.word);
            }
        });
        Map<String, Pair> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new Pair(word, 1));
                pq.offer(map.get(word));
            } else {
                Pair oldPair = map.get(word);
                map.put(word, new Pair(word, oldPair.frequency + 1));
                pq.remove(oldPair);
                pq.offer(map.get(word));
            }
        }
        List<String> res = new ArrayList<>();
        while (k > 0 && pq.size() > 0) {
            res.add(pq.poll().word);
            k--;
        }
        return res;
    }

    class Pair {
        String word;
        int frequency;
        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}
