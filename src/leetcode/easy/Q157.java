package leetcode.easy;

/**
 * Created by chen on 1/3/18.
 */
public class Q157 {
}

class Q157Solution {
    public int read(char[] buf, int n) {
        char[] toRead = new char[4];
        int res = 0;
        while (res < n) {
            int lettersRead = read4(toRead);
            int index = 0;
            while (index < lettersRead && res + index < n) {
                buf[res + index] = toRead[index];
                index++;
            }
            res = Math.min(n, res + index);
            if (lettersRead < 4 || res == n) {
                break;
            }
        }
        return res;
    }

    private int read4(char[] buff) {
        return 0;
    }
}