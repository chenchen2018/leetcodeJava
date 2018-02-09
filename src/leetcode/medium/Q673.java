package leetcode.medium;

import java.util.Arrays;

public class Q673 {
    public static void main(String[] args) {
        int[] input = {1,2,4,3,5,4,7,2};
        new Q673Solution().findNumberOfLIS(input);
    }
}

class Q673Solution {
    public int findNumberOfLIS(int[] nums) {
        //f[i] stands for LIS in which nums[i] is the last element
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n], count = new int[n];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        count[i] = count[j];
                    } else if (f[j] + 1 == f[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        //loop to find maximum
        int max = Arrays.stream(f).max().getAsInt();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (f[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}