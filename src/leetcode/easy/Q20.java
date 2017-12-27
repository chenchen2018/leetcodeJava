package leetcode.easy;

import java.util.Stack;

public class Q20 {
}

class Q20Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isLeftChar(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftChar(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isPair(char left, char right) {
        if (left == '(') {
            return right == ')';
        } else if (left == '[') {
            return right == ']';
        } else {
            return right == '}';
        }
    }
}