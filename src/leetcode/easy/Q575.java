package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Q575 {
}

class Q575Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int types = 0;
        for (int candy : candies) {
            if (!set.contains(candy)) {
                types++;
                set.add(candy);
            }
        }
        return types < candies.length / 2 ? types : candies.length / 2;
    }
}