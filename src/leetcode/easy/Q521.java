package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q521 {
    public static void main(String[] args) {
        new Q521Solution().test("abc");
    }
}

class Q521Solution {

    public void test(String s) {
        List<String> res = stringGeneratorRecursion(s);
        System.out.println("The size is: " + res.size());
        for (String string : res) {
            System.out.println(string);
        }
    }

    private List<String> stringGenerator(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < (1 << s.length()); i++) {
            String t = "";
            for (int j = 0; j < s.length(); j++) {
                if (((i >> j) & 1) != 0) {
                    t += s.charAt(j);
                }
            }
            res.add(t);
        }
        return res;
    }

    private List<String> stringGeneratorRecursion(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, s, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, String s, int startIndex) {
        if (startIndex >= s.length()) {
            return;
        }
        sb.append(s.charAt(startIndex));
        if (startIndex == s.length() - 1) {
            res.add(sb.toString());
        }
        helper(res, sb, s, startIndex + 1);
        sb.deleteCharAt(sb.length() - 1);
        if (startIndex == s.length() - 1) {
            res.add(sb.toString());
        }
        helper(res, sb, s, startIndex + 1);
    }
}