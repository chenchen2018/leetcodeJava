package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q140 {
}

class Q140Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return res;
        }
        Set<String> set = new HashSet<>(wordDict);
        helper(res, "", s, set, 0);
        return res;
    }

    private void helper(List<String> res, String curr, String s, Set<String> set, int startIndex) {
        for (int index = startIndex; index <= s.length(); index++) {
            String sub = s.substring(startIndex, index + 1);
            if (set.contains(sub)) {
                String newCurr = curr + sub + " ";
                if (index == s.length() - 1) {
                    res.add(curr.substring(0, newCurr.length() - 1));
                }
                set.remove(sub);
                helper(res, newCurr, s, set, index + 1);
                set.add(sub);
            }
        }
    }
}