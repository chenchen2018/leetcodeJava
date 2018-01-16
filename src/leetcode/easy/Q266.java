package leetcode.easy;

/**
 * Created by cchen on 1/16/18.
 */
public class Q266 {
}

class Q266Solution {
    //at most one character occurs odd times
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int[] counter = new int[128];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        boolean hasOdd = false;
        for (int count : counter) {
            if (count % 2 != 0) {
                if (hasOdd) {
                    return false;
                }
                hasOdd = true;
            }
        }
        return true;
    }
}