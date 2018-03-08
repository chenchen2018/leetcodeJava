package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Q500 {
}

class Q500Solution {
    public String[] findWords(String[] words) {
        //set up the map
        String[] allStrings = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int row = 0; row < allStrings.length; row++) {
            for (char c : allStrings[row].toCharArray()) {
                map.put(c, row);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (isValid(map, word)) {
                res.add(word);
            }
        }
        return res.stream().toArray(String[]::new);
    }

    private boolean isValid(Map<Character, Integer> map, String s) {
        if (s.isEmpty()) {
            return true;
        }
        int row = map.get(Character.toLowerCase(s.charAt(0)));
        return s.chars().mapToObj(i -> (char)i).allMatch(c -> map.get(Character.toLowerCase(c)) == row);
    }
}

