package leetcode.easy;

/**
 * Created by cchen on 3/7/18.
 */
public class Q476 {
    public static void main(String[] args) {
        System.out.println(new Q476Solution().findComplement(5));
    }
}

class Q476Solution {
    public int findComplement(int num) {
        int res = 0;
        int digit = 0;
        while (num > 0) {
            int mask = 1 - (num & 1);
            int shouldMove = digit;
            while (shouldMove > 0) {
                mask <<= 1;
                shouldMove--;
            }
            res |= mask;
            num >>= 1;
            digit++;
        }
        return res;
    }
}
