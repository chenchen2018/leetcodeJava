package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
}

class Q3Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
                right++;
                res = Math.max(res, right - left);
            } else {
                int endIndex = map.get(s.charAt(right));
                while (left <= endIndex) {
                    map.remove(s.charAt(left++));
                }
            }
        }
        return res;
    }
}
