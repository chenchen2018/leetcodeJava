package leetcode.medium;

public class Q8 {
    public static void main(String[] args) {
        new Q8Solution().myAtoi("1");
    }
}

class Q8Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long res = 0;
        int index = 0;
        int positive = 1;
        while (index < str.length()) {
            //first let's skip the white spaces in front
            while (str.charAt(index) == ' ') {
                index++;
            }
            //then followed by an optional plus or minus sign
            if (str.charAt(index) == '+') {
                index++;
            } else if (str.charAt(index) == '-') {
                positive = -1;
                index++;
            }
            //get the number
            while (index < str.length()) {
                char c = str.charAt(index);
                if (c >= '0' && c <= '9') {
                    res = res * 10 + (c - '0');
                    if (res > Integer.MAX_VALUE) {
                        return positive > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                } else {
                    return positive * (int)res;
                }
                index++;
            }
        }
        return positive * (int)res;
    }
}