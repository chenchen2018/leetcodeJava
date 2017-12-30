package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 12/30/17.
 */
public class Q39 {
    public static void main(String[] args) {
        System.out.println(new Q39Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

class Q39Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int startIndex) {
        for (int index = startIndex; index < candidates.length; index++) {
            if (target < candidates[index]) {
                return;
            }
            curr.add(candidates[index]);
            if (target - candidates[index] == 0) {
                res.add(new ArrayList<>(curr));
            }
            helper(res, curr, candidates, target - candidates[index], index);
            curr.remove(curr.size() - 1);
        }
    }
}
