package leetcode.hard;

public class Q312 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        new Q312Solution().maxCoins(nums);
    }
}

class Q312Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int index = 1; index < n + 1; index++) {
            A[index] = nums[index - 1];
        }
        int[][] f = new int[n + 2][n + 2];
        for (int i = 0; i < n + 1; i++) {
            f[i][i + 1] = 0;
        }
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int j = i + len - 1;
                f[i][j] = 0;
                for (int m = i + 1; m < j; m++) {
                    f[i][j] = Math.max(f[i][m] + f[m][j] + A[m] * A[i] * A[j], f[i][j]);
                }
            }
        }
        return f[0][n + 1];
    }
}