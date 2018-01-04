package leetcode.medium;

import java.util.Stack;

/**
 * Created by chen on 1/4/18.
 */
public class Q71 {
}

class Q71Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int index = 1;
        while (index < path.length()) {
            int startIndex = index;
            while (index < path.length() && path.charAt(index) != '/') {
                index++;
            }
            String folder = path.substring(startIndex, index);
            if (folder.equals("") || folder.equals(".")) {
                index++;
            } else if (folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                index++;
            } else {
                stack.push(folder);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}