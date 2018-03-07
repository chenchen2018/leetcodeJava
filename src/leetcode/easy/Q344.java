package leetcode.easy;

/**
 * Created by cchen on 3/7/18.
 */
public class Q344 {
}

class Q344Solution {
    public String reverseString(String s) {
        char[] input = s.toCharArray();
        int left = 0, right = input.length - 1;
        while (left < right) {
            char c = input[left];
            input[left] = input[right];
            input[right] = c;
            left++;
            right--;
        }
        return new String(input);
    }
}