package leetcode.hard;

public class Q72 {
}

class Q72Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        //f[i][j] stands for min distance to change first i characters to first j characters
        //f[i][j] =
        //insert a character to tail of word1: f[i][j - 1] + 1
        //delete a character to tail of word1: f[i - 1][j] + 1
        //change a character of tail of word1: f[i - 1][j - 1] + 1
        //do nothing if last character is same: f[i - 1][j - 1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = 0;
                    continue;
                }
                f[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j]);
                    if (j > 0) {
                        f[i][j] = Math.min(f[i - 1][j - 1] + 1, f[i][j]);
                        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                            f[i][j] = Math.min(f[i - 1][j - 1], f[i][j]);
                        }
                    }
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                }
            }
        }
        return f[m][n];
    }
}