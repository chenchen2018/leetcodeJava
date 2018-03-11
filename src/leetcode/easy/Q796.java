package leetcode.easy;

/**
 * Created by cchen on 3/11/18.
 */
public class Q796 {
}

class Q796Solution {
    public boolean rotateString(String A, String B) {
        return (A + A).indexOf(B) != -1;
    }
}
