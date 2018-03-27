package leetcode.easy;

/**
 * Created by cchen on 3/26/18.
 */
public class Q806 {
}

class Q806Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int currLine = 1, spaceLeft = 100;
        for (char c : S.toCharArray()) {
            if (widths[c - 'a'] > spaceLeft) {
                currLine++;
                spaceLeft = 100;
            }
            spaceLeft -= widths[c - 'a'];
        }
        int[] res = {currLine, 100 - spaceLeft};
        return res;
    }
}