package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 12/31/17.
 */
public class Q46 {
}

class Q46Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res,
                        List<Integer> curr,
                        int[] nums,
                        boolean[] visited) {
        for (int index = 0; index < nums.length; index++) {
            if (visited[index]) {
                continue;
            }
            curr.add(nums[index]);
            visited[index] = true;
            if (curr.size() == nums.length) {
                res.add(new ArrayList<>(curr));
            }
            helper(res, curr, nums, visited);
            curr.remove(curr.size() - 1);
            visited[index] = false;
        }
    }
}