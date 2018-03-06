package leetcode.easy;

/**
 * Created by cchen on 3/5/18.
 */
public class Q657 {
}

class Q657Solution {
    public boolean judgeCircle(String moves) {
        int rCount = 0, dCount = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    dCount--;
                    continue;
                case 'R':
                    rCount++;
                    continue;
                case 'D':
                    dCount++;
                    continue;
                case 'L':
                    rCount--;
                    continue;
            }
        }
        return rCount == 0 && dCount == 0;
    }
}
