package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 12/28/17.
 */
public class Q22 {
}

class Q22Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        if (n < 1) {
            return res;
        }
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String curr, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            helper(res, curr + "(", left + 1, right, n);
        }
        if (right < left) {
            helper(res, curr + ")", left, right + 1, n);
        }
    }
}
