package leetcode.easy;

public class Q387 {
}

class Q387Solution {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}