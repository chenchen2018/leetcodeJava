package leetcode.easy;

public class Q276 {
}

class Q276Solution {
    //Ok let's analyze what the heck is going on here.
    //For picking color for current house, it's (1): diff from prev one, which has k - 1 choices (2): same as prev one, but prev
    //one cannot be same as prev's prev one.
    //so f[i][0] stands for picking the color diff from previous one, f[i][1] stands for picking color same as prev one
    //f[i][0] = f[i - 1][1] + k - 1;
    public int numWays(int n, int k) {
        if (n < 1 || k < 1) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int[][] f = new int[n][2];
        f[0][0] = k;
        f[0][1] = k;
        f[1][0] = k * (k - 1);
        f[1][1] = k;
        for (int house = 2; house < n; house++) {
            f[house][0] = (k - 1) * (f[house - 1][0] + f[house - 1][1]);
            f[house][1] = f[house - 1][0];
        }
        return f[n - 1][0] + f[n - 1][1];
    }
}