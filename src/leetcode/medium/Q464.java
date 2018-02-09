package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q464 {
    public static void main(String[] args) {
        System.out.println(new Q464Solution().canIWin(4, 6));
    }
}

class Q464Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //sanity check
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        boolean[] used = new boolean[maxChoosableInteger + 1];
        int[] f = new int[1 << maxChoosableInteger];
        Arrays.fill(f, -1);
        return helper(used, f, desiredTotal);
    }

    private boolean helper(boolean[] used, int[] f, int target) {
        int index = transform(used);
        if (f[index] == -1) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    if (i >= target) {
                        f[index] = 1;
                        return true;
                    }
                    used[i] = true;
                    if (!helper(used, f, target - i)) {
                        f[index] = 1;
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            f[index] = 0;
        }
        return f[index] == 1;
    }

    private int transform(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) {
                num |= 1;
            }
        }
        return num;
    }
}