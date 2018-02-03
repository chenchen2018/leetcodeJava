package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cchen on 2/3/18.
 */
public class Q403 {
    public static void main(String[] args) {
        int[] stones = {0,1,3,4,5,7,9,10,12};
        new Q403Solution().canCross(stones);
    }
}

class Q403Solution {
    //brute force dp
    //TLE
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2) {
            return true;
        }
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        int n = stones.length;
        boolean[][] f = new boolean[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        //load stones into map
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        //init
        f[1][1] = true;
        for (int i = 2 ; i < n; i++) {
            f[1][i] = false;
        }
        //start from third stone
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //f[i][j] stands for jumping j steps and we reach ith stone
                for (int delta = -1; delta <= 1; delta++) {
                    int lastJump = j + delta;
                    int lastStone = stones[i] - j;
                    if (lastJump < n && map.containsKey(lastStone) && f[map.get(lastStone)][lastJump]) {
                        f[i][j] = true;
                        continue;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) {
                return true;
            }
        }
        return false;
    }

    public boolean canCross2(int[] stones) {
        if (stones == null || stones.length < 2) {
            return true;
        }
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<Integer>());
        }
        map.get(stones[0]).add(0);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int jump : map.get(stone)) {
                for (int delta = -1; delta <= 1; delta++) {
                    int newJump = jump + delta;
                    if (newJump > 0 && map.containsKey(stone + newJump)) {
                        map.get(stone + newJump).add(newJump);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}