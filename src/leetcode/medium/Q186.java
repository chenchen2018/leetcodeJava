package leetcode.medium;

public class Q186 {
}

class Q186Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0, end = 0;
        while (end < str.length) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
                end = start;
            } else {
                end++;
            }
        }
        reverse(str, start, end - 1);
    }

    private void reverse(char[] input, int left, int right) {
        while (left < right) {
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
    }
}