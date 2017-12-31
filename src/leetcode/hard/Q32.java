package leetcode.hard;

import java.util.Stack;

/**
 * Created by chen on 12/31/17.
 */
public class Q32 {
    public static void main(String[] args) {
        System.out.println(new Q32Solution().longestValidParentheses2("(()"););
    }
}

class Q32Solution {
    //brute force solution (TLE)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int res = 0;
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            int index = startIndex;
            int leftCount = 0, rightCount = 0;
            while (index < s.length()) {
                if (s.charAt(index) == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                    if (rightCount == leftCount) {
                        res = Math.max(res, index - startIndex + 1);
                    } else if (rightCount > leftCount) {
                        break;
                    }
                }
                index++;
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int res = 0;
        int accumulatedLength = 0, currLength = 0;
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                stack.push(index);
            } else {
                if (stack.isEmpty()) {
                    accumulatedLength = 0;
                } else {
                    currLength = index - stack.pop() + 1;
                    if (stack.isEmpty()) {
                        accumulatedLength += currLength;
                        currLength = accumulatedLength;
                    } else {
                        currLength = index - stack.peek();
                    }
                }
                res = Math.max(res, currLength);
            }
        }
        return res;
    }
}