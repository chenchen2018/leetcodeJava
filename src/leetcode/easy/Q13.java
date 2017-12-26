package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q13 {
}

class Q13Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0, index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length() && map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
                res += map.get(s.charAt(index + 1)) - map.get(s.charAt(index));
                index += 2;
            } else {
                res += map.get(s.charAt(index));
                index++;
            }
        }
        return res;
    }
}