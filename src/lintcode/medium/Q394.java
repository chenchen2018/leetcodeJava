package lintcode.medium;

/**
 * Created by cchen on 1/27/18.
 */
public class Q394 {
}

class Q394Solution {
    public boolean firstWillWin(int n) {
        // write your code here
        if (n < 3) {
            return true;
        }
        boolean[] f = new boolean[n + 1];
        f[1] = true;
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] == false) || (f[i - 2] == false);
        }
        return f[n];
    }
}