package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q205 {
}

class Q205Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
            return t == null || t.length() == 0;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char sChar = s.charAt(index), tChar = t.charAt(index);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}