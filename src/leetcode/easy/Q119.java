package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 12/31/17.
 */
public class Q119 {
}

class Q119Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        int row = 0;
        res.add(1);
        while (row < rowIndex) {
            row++;
            List<Integer> nextLevel = new ArrayList<>();
            for (int index = 0; index <= row; index++) {
                if (index == 0 || index == row) {
                    nextLevel.add(1);
                } else {
                    nextLevel.add(res.get(index - 1) + res.get(index));
                }
            }
            res = nextLevel;
        }
        return res;
    }
}