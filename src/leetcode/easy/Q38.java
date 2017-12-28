package leetcode.easy;

/**
 * Created by chen on 12/28/17.
 */
public class Q38 {
}

class Q38Solution {
    public String countAndSay(int n) {
        String res = "1";
        while (n > 1) {
            res = generateNext(res);
            n--;
        }
        return res;
    }

    private String generateNext(String input) {
        StringBuilder sb = new StringBuilder();
        int index = 1, counter = 1;
        char curr = input.charAt(0);
        while (index < input.length()) {
            if (input.charAt(index) == curr) {
                index++;
                counter++;
            } else {
                sb.append(counter);
                sb.append(curr);
                counter = 1;
                curr = input.charAt(index);
                index++;
            }
        }
        sb.append(counter);
        sb.append(curr);
        return sb.toString();
    }
}