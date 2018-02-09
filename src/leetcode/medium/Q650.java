package leetcode.medium;

import java.util.Arrays;

public class Q650 {
    public static void main(String[] args) {
        new Q650Solution().minSteps2(4);
    }
}

class Q650Solution {
    //dp1: not working. forget about it
    public int minSteps(int n) {
        int[] f = new int[1000];
        //f[i] stands for after i operations, maximum A's we can get
        f[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i - 1];
            for (int j = 0; j < i; j++) {
                f[i] = Math.max(f[i], f[j] * (i - j));
            }
        }
        for (int i = 0; i < f.length; i++) {
            if (f[i] >= n) {
                return i;
            }
        }
        return -1;
    }

    //this dp works
    public int minSteps2(int n) {
        int[] f = new int[n + 1];
        f[1] = 0;
        for (int i = 2; i <= n; i++) {
            f[i] = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                }
            }
        }
        return f[n];
    }
}