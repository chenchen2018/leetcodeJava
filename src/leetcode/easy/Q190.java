package leetcode.easy;

/**
 * Created by chen on 1/5/18.
 */
public class Q190 {
}

class Q190Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int step = 0;
        while (step < 32) {
            int digit = n & 1;
            res = ((res << 1) | (n & 1));
            n >>>= 1;
            step++;
        }
        return res;
    }
}