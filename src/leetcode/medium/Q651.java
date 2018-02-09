package leetcode.medium;

/**
 * Created by cchen on 2/8/18.
 */
public class Q651 {
    public static void main(String[] args) {
        new Q651Solution().maxA(7);
    }
}

class Q651Solution {
    public int maxA(int N) {
        int[] best = new int[N+1];
        for (int k = 1; k <= N; ++k) {
            best[k] = best[k-1] + 1;
            for (int x = 0; x < k-1; ++x)
                best[k] = Math.max(best[k], best[x] * (k-x-1));
        }
        return best[N];
    }
}
