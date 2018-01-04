package leetcode.easy;

import java.util.Stack;

/**
 * Created by chen on 1/3/18.
 */
public class Q155 {
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack2 {
    Integer currMin;
    Stack<Res> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (currMin == null || currMin > x) {
            currMin = x;
        }
        stack.push(new Res(currMin, x));
    }

    public void pop() {
        Res res = stack.pop();
        if (res.min == currMin) {
            if (stack.isEmpty()) {
                currMin = null;
            } else {
                currMin = getMin();
            }
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class Res {
        int min;
        int value;
        public Res(int min, int value) {
            this.min = min;
            this.value = value;
        }
    }
}