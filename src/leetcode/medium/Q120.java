package leetcode.medium;

import java.util.List;

public class Q120 {
}

class Q120Solution {
    //first let's do it in normal dp way
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int level = 1; level < triangle.size(); level++) {
            List<Integer> currLevel = triangle.get(level);
            for (int index = 0; index < currLevel.size(); index++) {
                if (index == 0) {
                    f[level][index] = f[level - 1][index] + currLevel.get(index);
                } else if (index == currLevel.size() - 1) {
                    f[level][index] = f[level - 1][index - 1] + currLevel.get(index);
                } else {
                    f[level][index] = currLevel.get(index) + Math.min(f[level - 1][index - 1], f[level - 1][index]);
                }
            }
        }
        int res = f[n - 1][0];
        for (int index = 1; index < n; index++) {
            res = Math.min(res, f[n - 1][index]);
        }
        return res;
    }

    //Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    //ok: rotating array
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[][] f = new int[2][n];
        int prev = 0, curr = 1;
        f[prev][0] = triangle.get(0).get(0);
        for (int row = 1; row < n; row++) {
            List<Integer> currList = triangle.get(row);
            for (int col = 0; col < currList.size(); col++) {
                if (col == 0) {
                    f[curr][col] = f[prev][col] + currList.get(col);
                } else if (col == currList.size() - 1) {
                    f[curr][col] = f[prev][col - 1] + currList.get(col);
                } else {
                    f[curr][col] = currList.get(col) + Math.min(f[prev][col - 1], f[prev][col]);
                }
            }
            prev = curr;
            curr = 1 - curr;
        }
        int res = f[prev][0];
        for (int col = 1; col < n; col++) {
            res = Math.min(res, f[prev][col]);
        }
        return res;
    }
}