package leetcode.medium;

import java.util.Arrays;

/**
 * Created by chen on 3/31/18.
 */
public class Q452 {
}

class Q452Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (e1, e2) -> {
            return e1[1] - e2[1];
        });
        int lastEnd = points[0][1], arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (lastEnd < points[i][0]) {
                arrows++;
                lastEnd = points[i][1];
            }
        }
        return arrows;
    }
}