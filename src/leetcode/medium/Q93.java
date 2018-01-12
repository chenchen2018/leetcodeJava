package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public static void main(String[] args) {
        List<String> res = new Q93Solution().restoreIpAddresses("010010");
        System.out.println(res);
    }
}

class Q93Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        helper(res, s, "", 0, 0);
        return res;
    }

    private void helper(List<String> res, String s, String curr, int startIndex, int dots) {
        for (int index = startIndex; index < s.length() && index < startIndex + 3; index++) {
            if (isValid(s.substring(startIndex, index + 1))) {
                if (dots == 3 && index == s.length() - 1) {
                    res.add(curr + s.substring(startIndex, index + 1));
                    return;
                }
                if (dots < 3) {
                    helper(res, s, curr + s.substring(startIndex, index + 1) + ".", index + 1, dots + 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int ip = Integer.parseInt(s);
        return ip >= 0 && ip < 256;
    }
}