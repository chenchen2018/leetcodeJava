package leetcode.easy;

/**
 * Created by cchen on 3/7/18.
 */
public class Q557 {
}

class Q557Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0, startIndex = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                sb.append(' ');
                index++;
            } else {
                startIndex = index;
                while (index < s.length() && s.charAt(index) != ' ') {
                    index++;
                }
                sb.append(reverseWord(s.substring(startIndex, index)));
            }
        }
        return sb.toString();
    }

    private String reverseWord(String s) {
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
