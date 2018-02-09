package leetcode.medium;

public class Q647 {
}

class Q647Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 0;
        boolean[][] isPalin = new boolean[n][n];
        construct(isPalin, s);
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] + 1;
            for (int j = 1; j < i; j++) {
                if (isPalin[j - 1][i - 1]) {
                    f[i]++;
                }
            }
        }
        return f[n];
    }

    private void construct(boolean[][] isPalin, String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }
        for (int i = 0; i + 1 < n; i++) {
            isPalin[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                isPalin[i][j] = isPalin[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }
}