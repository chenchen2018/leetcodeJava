package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q293 {
}

class Q293Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return res;
        }
        for (int index = 0; index < s.length() - 1; index++) {
            if (s.charAt(index) == '+' && s.charAt(index + 1) == '+') {
                res.add(s.substring(0, index) + "--" + s.substring(index + 2));
            }
        }
        return res;
    }
}