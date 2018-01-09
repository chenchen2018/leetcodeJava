package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q89 {
}

class Q89Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 1) {
            for (int index = 0; index <= n; index++) {
                res.add(index);
            }
            return res;
        }
        List<Integer> prev = grayCode(n - 1);
        res.addAll(prev);
        Collections.reverse(prev);
        int toAdd = 1 << (n - 1);
        for (int index = 0; index < prev.size(); index++) {
            res.add(prev.get(index) + toAdd);
        }
        return res;
    }
}