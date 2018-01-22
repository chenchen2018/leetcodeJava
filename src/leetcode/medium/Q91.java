package leetcode.medium;

public class Q91 {
}

class Q91Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] ways = new int[s.length()];
        ways[0] = 1;
        if (isValid(s.substring(1, 2))) {
            ways[1] = ways[0];
        }
        if (isValid(s.substring(0, 2))) {
            ways[1]++;
        }
        for (int index = 2; index < s.length(); index++) {
            if (isValid(s.substring(index, index + 1))) {
                ways[index] = ways[index - 1];
            }
            if (isValid(s.substring(index - 1, index + 1))) {
                ways[index] += ways[index - 2];
            }
        }
        return ways[s.length() - 1];
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int input = Integer.parseInt(s);
        return input >= 1 && input <= 26;
    }

    //用序列型来做
    public int numDecodings2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        char[] array = s.toCharArray();

        int num1, num2;

        for (int index = 1; index <= n; index++) {
            f[index] = 0;
            num1 = array[index - 1] - '0';
            if (num1 > 0 &&num1 <= 9) {
                f[index] = f[index - 1];
            }
            if (index > 1) {
                num2 = (array[index - 2] - '0') * 10 + array[index - 1] - '0';
                if (num2 >= 10 && num2 <= 26) {
                    f[index] += f[index - 2];
                }
            }
        }

        return f[n];
    }
}