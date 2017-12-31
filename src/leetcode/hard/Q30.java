package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 12/30/17.
 */
public class Q30 {
}

class Q30Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> targets = new HashMap<>(), found = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String word : words) {
            targets.put(word, targets.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length(), totalLength = s.length();
        for (int index = 0; index <= totalLength - words.length * wordLength; index++) {
            int startIndex = index, count = 0;
            found.clear();
            while (count < words.length) {
                String currWord = s.substring(startIndex + count * wordLength, startIndex + count * wordLength + wordLength);
                if (!targets.containsKey(currWord)) {
                    break;
                }
                found.put(currWord, found.getOrDefault(currWord, 0) + 1);
                if (found.get(currWord) > targets.get(currWord)) {
                    break;
                }
                count++;
            }
            if (count == words.length) {
                res.add(startIndex);
            }
        }
        return res;
    }
}