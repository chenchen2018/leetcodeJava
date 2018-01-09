package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {
}

class Q90Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), nums, visited, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] visited, int startIndex) {
        for (int index = startIndex; index < nums.length; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                if (!visited[index - 1]) {
                    continue;
                }
            }
            curr.add(nums[index]);
            res.add(new ArrayList<Integer>(curr));
            visited[index] = true;
            helper(res, curr, nums, visited, index + 1);
            curr.remove(curr.size() - 1);
            visited[index] = false;
        }
    }
}