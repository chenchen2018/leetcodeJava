package leetcode.hard;

import java.util.Stack;

/**
 * Created by cchen on 3/17/18.
 */
public class Q716 {
    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(-5);
        maxStack.popMax();
        maxStack.popMax();
        maxStack.top();
    }
}

class MaxStack {
    Stack<Integer> stack, maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            int max = x > maxStack.peek() ? x : maxStack.peek();
            maxStack.push(max);
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (top() != max) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }
}