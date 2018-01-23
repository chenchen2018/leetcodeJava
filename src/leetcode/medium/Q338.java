package leetcode.medium;

/**
 * Created by cchen on 1/22/18.
 */
public class Q338 {
}

class Q338Solution {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        f[0] = 0;

        for (int number = 1; number <= num; number++) {
            f[number] = f[number >> 1] + number % 2;
        }

        return f;
    }
}
