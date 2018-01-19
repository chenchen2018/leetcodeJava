package leetcode.medium;

import java.util.Stack;

public class Q150 {
}

class Q150Soluton {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < tokens.length; index++) {
            if (isOperator(tokens[index])) {
                //here we assume all the operations are valid
                stack.push(doOperation(stack.pop(), stack.pop(), tokens[index]));
            } else {
                stack.push(Integer.valueOf(tokens[index]));
            }
        }
        return stack.pop();
    }

    private int doOperation(int a, int b, String operator) {
        switch (operator) {
            case "+" : return b + a;
            case "-" : return b - a;
            case "*" : return b * a;
            case "/" : return b / a;
        }
        return 0;
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
}