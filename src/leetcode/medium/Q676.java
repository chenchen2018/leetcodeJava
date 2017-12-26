package leetcode.medium;

import java.util.*;

public class Q676 {
}

class MagicDictionary {
    Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            if (!map.containsKey(word.length())) {
                map.put(word.length(), new ArrayList<String>());
            }
            map.get(word.length()).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (map.get(word.length()) == null) {
            return false;
        }
        for (String candidate : map.get(word.length())) {
            for (int index = 0; index < word.length(); index++) {
                if (candidate.charAt(index) != word.charAt(index)) {
                    if (candidate.substring(index + 1, candidate.length()).equals(word.substring(index + 1, word.length()))) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}

class MagicDictionary2 {
    Set<String> words;
    Map<String, Integer> counts;

    /** Initialize your data structure here. */
    public MagicDictionary2() {
        words = new HashSet<>();
        counts = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            words.add(word);
            for (String transformedWord : transform(word)) {
                counts.put(transformedWord, counts.getOrDefault(transformedWord, 0) + 1);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String transformedWord : transform(word)) {
            if (!counts.containsKey(transformedWord)) {
                continue;
            }
            if (counts.get(transformedWord) > 1) {
                return true;
            }
            if (counts.get(transformedWord) == 1 && !words.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private List<String> transform(String s) {
        List<String> res = new ArrayList<>();
        for (int index = 0; index < s.length(); index++) {
            res.add(s.substring(0, index) + "*" + s.substring(index + 1, s.length()));
        }
        return res;
    }
}