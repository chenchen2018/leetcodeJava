package leetcode.hard;

import java.util.Arrays;

/**
 * Created by cchen on 1/27/18.
 */
public class Q354 {
}

class Q354Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (e1, e2) -> {
           return e1[0] - e2[0];
        });
        int res = 0;
        int n = envelopes.length;
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            for (int i = 0; i < j; i++) {
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            res = Math.max(res, f[j]);
        }
        return res;
    }
}