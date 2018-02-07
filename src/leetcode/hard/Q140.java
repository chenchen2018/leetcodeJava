package leetcode.hard;

import java.util.*;

public class Q140 {
}

class Q140Solution {
    //TLE
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

    //典型的划分性动态规划 TLE
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return res;
        }
        int n = s.length();
        List<String>[] f = new LinkedList[n + 1];
        List<String> init = new LinkedList<>();
        init.add("");
        f[0] = init;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            List<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (f[j].size() > 0 && set.contains(s.substring(j, i))) {
                    for (String string : f[j]) {
                        list.add(string + " " + s.substring(j, i));
                    }
                }
            }
            f[i] = list;
        }

        //formalize the final result
        for (String string : f[n]) {
            res.add(string.substring(1));
        }
        return res;
    }

}

class Q140Solution2 {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> temp = helper(s, new HashSet<String>(wordDict), 0);
        List<String> res = new ArrayList<>();
        for (String string : temp) {
            res.add(string.substring(0, string.length() - 1));
        }
        return res;
    }

    private List<String> helper(String s, Set<String> set, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int index = start; index < s.length(); index++) {
            String temp = s.substring(start, index + 1);
            if (set.contains(temp)) {
                List<String> after = helper(s, set, index + 1);
                if (after.size() > 0) {
                    for (String string : after) {
                        res.add(temp + " " + string);
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }
}