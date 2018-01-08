package leetcode.medium;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q81 {
}

class Q81Solution {
    //in this case, you really cannot use binary search. Why? Think of 1, 1, 1, 1, 1, 1, 0
    //now the middle is 1, so which way shall you go? left or right?
    public boolean search(int[] nums, int target) {
        return Arrays.stream(nums).anyMatch(num -> num == target);
    }
}