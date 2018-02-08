package leetcode.medium;

public class Q740 {
}

//The length of nums is at most 20000.
//Each element nums[i] is an integer in the range [1, 10000].
class Q740Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[10001];
        for (int num : nums) {
            count[num]++;
        }
        //f[i][0] stands for not using this value to earn, the maximum earned till here
        //f[i][1] stands for using this value to earn
        int[][] f = new int[10001][2];
        for (int i = 1; i <= 10000; i++) {
            if (count[i] == 0) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i][0];
            } else {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i - 1][0] + i * count[i];
            }
        }
        return Math.max(f[10000][0], f[10000][1]);
    }
}
