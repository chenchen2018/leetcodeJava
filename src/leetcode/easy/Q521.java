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
        for (String string : stringGenerator(s)) {
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
}