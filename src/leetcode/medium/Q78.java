package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 1/8/18.
 */
public class Q78 {
}

class Q78Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int startIndex) {
        for (int index = startIndex; index < nums.length; index++) {
            curr.add(nums[index]);
            res.add(new ArrayList<Integer>(curr));
            helper(res, curr, nums, index + 1);
            curr.remove(curr.size() - 1);
        }
    }
}