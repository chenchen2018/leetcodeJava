package leetcode.medium;

import java.util.List;

public class Q139 {
}

class Q139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int index = 0; index <= n; index++) {
            if (!f[index]) {
                continue;
            }
            for (String string : wordDict) {
                if (index + string.length() > n) {
                    continue;
                }
                if (string.equals(s.substring(index, index + string.length()))) {
                    f[index + string.length()] = true;
                }
            }
        }
        return f[n];
    }
}