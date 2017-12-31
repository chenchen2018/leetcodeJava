package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 12/30/17.
 */
public class Q40 {
}

class Q40Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, new boolean[candidates.length], target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res,
                        List<Integer> curr,
                        int[] candidates,
                        boolean[] visited,
                        int target,
                        int startIndex) {
        for (int index = startIndex; index < candidates.length; index++) {
            if (index > 0 && candidates[index] == candidates[index - 1] && !visited[index - 1]) {
                continue;
            }
            if (candidates[index] > target) {
                return;
            }
            curr.add(candidates[index]);
            if (target - candidates[index] == 0) {
                res.add(new ArrayList<>(curr));
            }
            visited[index] = true;
            helper(res, curr, candidates, visited, target - candidates[index], index + 1);
            curr.remove(curr.size() - 1);
            visited[index] = false;
        }
    }
}
