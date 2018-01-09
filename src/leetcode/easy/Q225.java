package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q225 {
}

class MyStack {
    Queue<Integer> queue;
    int last;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        last = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int times = queue.size() - 1;
        while (times > 0) {
            times--;
            last = queue.poll();
            queue.offer(last);
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return last;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */