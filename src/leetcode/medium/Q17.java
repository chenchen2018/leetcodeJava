package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 12/28/17.
 */
public class Q17 {
}

class Q17Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        String[] letters = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(res, "", letters, digits, 0);
        return res;
    }

    private void helper(List<String> res, String curr, String[] letters, String digits, int index) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        }
        String combinations = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < combinations.length(); i++) {
            helper(res, curr + combinations.charAt(i), letters, digits, index + 1);
        }
    }
}