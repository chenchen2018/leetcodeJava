package leetcode.easy;

/**
 * Created by chen on 1/1/18.
 */
public class Q125 {
    public static void main(String[] args) {
        System.out.println(Character.isLetterOrDigit('1'));
    }
}

class Q125Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            if (left >= right) {
                return true;
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}