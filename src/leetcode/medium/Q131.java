package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
}

class Q131Solution {
    //first let's do it in a normal dfs way
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        helper(res, new ArrayList<String>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> curr, String s, int startIndex) {
        for (int index = startIndex; index < s.length(); index++) {
            if (isPanlindrome(s, startIndex, index)) {
                curr.add(s.substring(startIndex, index + 1));
                if (index == s.length() - 1) {
                    res.add(new ArrayList<String>(curr));
                }
                helper(res, curr, s, index + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPanlindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Q131Solution2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        boolean[][] isPalindrome = constructPalindrome(s);
        helper(res, new ArrayList<String>(), s, isPalindrome, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> curr, String s, boolean[][] isPalindrome, int startIndex) {
        for (int index = startIndex; index < s.length(); index++) {
            if (isPalindrome[startIndex][index]) {
                curr.add(s.substring(startIndex, index + 1));
                if (index == s.length() - 1) {
                    res.add(new ArrayList<>(curr));
                }
                helper(res, curr, s, isPalindrome, index + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean[][] constructPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        //f[i][j] stands for char sequence from position i to position j is palindrome
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return f;
    }
}