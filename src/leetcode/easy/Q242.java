package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q242 {
}

class Q242Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.isEmpty()) {
            return t == null || t.isEmpty();
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || s.isEmpty()) {
            return t == null || t.isEmpty();
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!counter.containsKey(c)) {
                return false;
            }
            int occurance = counter.get(c);
            if (occurance == 1) {
                counter.remove(c);
            } else {
                counter.put(c, occurance - 1);
            }
        }
        return true;
    }
}