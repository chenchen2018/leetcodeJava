package leetcode.medium;

import java.util.*;

/**
 * Created by cchen on 1/26/18.
 */
public class LongestChain {
    public static void main(String[] args) {
        String[] input = {"bdca", "bda", "ba", "bca", "a", "b"};
        System.out.println(new Solution().longestChain(input));
    }
}

class Solution {
    public int longestChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (s1, s2) -> {return s1.length() - s2.length();});
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        int longest = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 1);
            for (int index = 0; index < word.length(); index++) {
                String temp = word.substring(0, index) + word.substring(index + 1, word.length());
                if (set.contains(temp)) {
                    int length = map.get(temp) + 1;
                    if (length > map.get(word)) {
                        map.put(word, length);
                    }
                    longest = Math.max(longest, length);
                }
            }
        }
        return longest;
    }
}