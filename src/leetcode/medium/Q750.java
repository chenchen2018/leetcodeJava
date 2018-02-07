package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cchen on 2/7/18.
 */
public class Q750 {
}

class Q750Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0].length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                for (int col2 = col + 1; col2 < grid[0].length; col2++) {
                    if (grid[row][col2] == 1) {
                        int count = map.getOrDefault(col * 200 + col2, 0);
                        res += count;
                        map.put(col * 200 + col2, count + 1);
                    }
                }
            }
        }
        return res;
    }
}