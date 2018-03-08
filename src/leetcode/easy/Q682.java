package leetcode.easy;

import java.util.Stack;

//Integer (one round's score): Directly represents the number of points you get in this round.
//        "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
//        "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
//        "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
public class Q682 {
}

class Q682Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int last = stack.pop(), lastLast = stack.pop();
                stack.push(lastLast);
                stack.push(last);
                stack.push(lastLast + last);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}