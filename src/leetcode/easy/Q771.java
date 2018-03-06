package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cchen on 3/5/18.
 */
public class Q771 {
}

class Q771Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int counter = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                counter++;
            }
        }
        return counter;
    }
}
