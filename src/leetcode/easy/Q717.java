package leetcode.easy;

/**
 * Created by cchen on 3/10/18.
 */
public class Q717 {
    public static void main(String[] args) {
        new Q717Solution().isOneBitCharacter2(new int[]{1, 0, 0});
    }
}

class Q717Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        return helper(bits, 0);
    }

    private boolean helper(int[] bits, int index) {
        if (index >= bits.length) {
            return false;
        }
        if (index == bits.length - 1) {
            return bits[index] == 0;
        }
        if (bits[index] == 0) {
            return helper(bits, index + 1);
        } else {
            return helper(bits, index + 2);
        }
    }

    public boolean isOneBitCharacter2(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        if (bits.length == 1) {
            return bits[0] == 0;
        }
        if (bits[bits.length - 1] != 0) {
            return false;
        }
        boolean[] f = new boolean[bits.length + 1];
        f[0] = true;
        f[1] = bits[0] == 0;
        for (int length = 2; length <= bits.length; length++) {
            if (length == bits.length) {
                return f[length - 1];
            }
            if (bits[length - 1] == 0) {
                f[length] = f[length - 1];
                if (bits[length - 2] == 1) {
                    f[length] |= f[length - 2];
                }
            } else {
                if (bits[length - 2] == 1) {
                    f[length] |= f[length - 2];
                }
            }
        }
        return true;
    }
}
