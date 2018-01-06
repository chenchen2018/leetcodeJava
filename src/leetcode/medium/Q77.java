package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 1/5/18.
 */
public class Q77 {
}

class Q77Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int start, int end, int k) {
        for (int num = start; num <= end; num++) {
            temp.add(num);
            if (temp.size() == k) {
                res.add(new ArrayList<Integer>(temp));
            }
            helper(res, temp, num + 1, end, k);
            temp.remove(temp.size() - 1);
        }
    }
}