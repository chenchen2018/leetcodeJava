package leetcode.easy;

/**
 * Created by cchen on 3/6/18.
 */
public class Q461 {
    public static void main(String[] args) {
        new Q461Solution().hammingDistance(1, 4);
    }
}

class Q461Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x != y) {
            if ((x & 1) != (y & 1)) {
                res++;
            }
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}