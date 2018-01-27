package leetcode.hard;

/**
 * Created by cchen on 1/26/18.
 */
public class Q265 {
}

class Q265Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int houses = costs.length, colors = costs[0].length;

        if (colors == 1) {
            return costs[0][0];
        }

        int[][] f = new int[houses + 1][colors];

        for (int i = 1; i <= houses; i++) {
            for (int j = 0; j < colors; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (j != k) {
                        f[i][j] = Math.min(f[i][j], costs[i - 1][j] + f[i - 1][k]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int color = 0; color < colors; color++) {
            res = Math.min(res, f[houses][color]);
        }
        return res;
    }

    public int minCostII2(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int houses = costs.length, colors = costs[0].length;
        if (colors == 1) {
            return costs[0][0];
        }

        int[][] f = new int[2][colors];

        int old = 0, now = 1;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int small1 = 0, small2 = 0;

        for (int house = 1; house < houses; house++) {
            old = now;
            now = 1 - now;
            //loop through last house
            for (int color = 0; color < colors; color++) {
                if (f[old][color] < min1) {
                    min2 = min1;
                    small2 = small1;
                    min1 = f[old][color];
                    small1 = color;
                } else if (f[old][color] < min2) {
                    min2 = f[old][color];
                    small2 = color;
                }
            }
            for (int color = 0; color < colors; color++) {
                if (color != small1) {
                    f[now][color] = costs[house - 1][color] + min1;
                } else {
                    f[now][color] = costs[house - 1][color] + min2;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int color = 0; color < colors; color++) {
            res = Math.min(res, f[now][color]);
        }
        return res;
    }
}