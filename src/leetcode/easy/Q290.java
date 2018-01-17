package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q290 {
}

class Q290Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.isEmpty()) {
            return str == null || str.isEmpty();
        }
        String[] inputs = str.split(" ");
        if (pattern.length() != inputs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int index = 0; index < pattern.length(); index++) {
            char key = pattern.charAt(index);
            String input = inputs[index];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(input)) {
                    return false;
                }
            } else {
                if (map.containsValue(input)) {
                    return false;
                }
                map.put(key, input);
            }
        }
        return true;
    }
}