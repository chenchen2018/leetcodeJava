package leetcode.easy;

public class Q14 {
}

class Q14Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs == null || strs.length == 0) {
            return res;
        }
        for (int position = 0; position < strs[0].length(); position++) {
            char curr = strs[0].charAt(position);
            for (int index = 1; index < strs.length; index++) {
                if (position >= strs[index].length() || curr != strs[index].charAt(position)) {
                    return res;
                }
            }
            res += curr;
        }
        return res;
    }
}