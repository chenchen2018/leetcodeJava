package leetcode.medium;

public class Q151 {
}

class Q151Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        //actually the pattern is like first a bunch of white spaces, followed by a bunch of characters, then spaces again...
        boolean checkingSapce = true;
        while (index >= 0) {
            if (checkingSapce) {
                while (index >= 0 && s.charAt(index) == ' ') {
                    index--;
                }
                checkingSapce = false;
            } else {
                int endIndex = index;
                while (index >= 0 && s.charAt(index) != ' ') {
                    index--;
                }
                sb.append(s.substring(index + 1, endIndex + 1) + " ");
                checkingSapce = true;
            }
        }
        return sb.length() == 0 ? sb.toString() : sb.substring(0, sb.length() - 1);
    }
}