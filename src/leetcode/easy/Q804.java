package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cchen on 3/26/18.
 */
public class Q804 {
}

class Q804Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(transform(word, code));
        }
        return set.size();
    }

    private String transform(String s, String[] code) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(code[c - 'a']);
        }
        return sb.toString();
    }
}