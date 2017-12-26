package leetcode.medium;

import java.util.*;

public class Q49 {
}

class Q49Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            String key = getKey(string);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        res.addAll(map.values());
        return res;
    }

    private String getKey(String s) {
        char[] input = s.toCharArray();
        Arrays.sort(input);
        return new String(input);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] counter = new int[26];
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(counter, 0);
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : counter) {
                sb.append("#" + count);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}
