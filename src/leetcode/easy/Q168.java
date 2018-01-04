package leetcode.easy;

/**
 * Created by chen on 1/3/18.
 */
public class Q168 {
}

class Q168Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remain = n % 26;
            n /= 26;
            if (remain == 0) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0, (char)('A' + remain - 1));
            }
        }
        return sb.toString();
    }
}