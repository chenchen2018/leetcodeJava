package leetcode.hard;

/**
 * Created by cchen on 1/27/18.
 */
public class Q132 {
}

class Q132Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPanli = new boolean[n][n];
        //odd length
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                isPanli[left][right] = true;
                left--;
                right++;
            }
        }
        //even length
        for (int i = 0; i < n; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                isPanli[left][right] = true;
                left--;
                right++;
            }
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        for (int j = 1; j <= n; j++) {
            f[j] = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (isPanli[i][j-  1]) {
                    f[j] = Math.min(f[j], f[i] + 1);
                }
            }
        }
        return f[n] - 1;
    }
}