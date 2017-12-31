package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 12/31/17.
 */
public class Q118 {
}

class Q118Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        int row = 1;
        while (row <= numRows) {
            List<Integer> curr = new ArrayList<>();
            for (int index = 0; index < row; index++) {
                if (index == 0 || index == row - 1) {
                    curr.add(1);
                    continue;
                }
                curr.add(res.get(row - 2).get(index - 1) + res.get(row - 2).get(index));
            }
            res.add(curr);
            row++;
        }
        return res;
    }
}
