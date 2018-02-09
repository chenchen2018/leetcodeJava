package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Q464 {
}

class Q464Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //sanity check
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }


    }
}