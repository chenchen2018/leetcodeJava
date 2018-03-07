package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchen on 3/7/18.
 */
public class Q728 {
}

class Q728Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while (left <= right) {
            if (isValid(left)) {
                res.add(left);
            }
            left++;
        }
        return res;
    }

    private boolean isValid(int input) {
        int num = Math.abs(input);
        int origin = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || origin % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}