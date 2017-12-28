package leetcode.easy;

/**
 * Created by chen on 12/27/17.
 */
public class Q58 {
}

class Q58Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //first skip white spaces
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        if (index < 0) {
            return 0;
        }
        //count the length of last word
        int front = index;
        while (front >= 0 && Character.isAlphabetic(s.charAt(front))) {
            front--;
        }
        return index - front;
    }
}