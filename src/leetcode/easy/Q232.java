package leetcode.easy;

import java.util.Stack;

public class Q232 {
}

class MyQueue {
    Stack<Integer> storage;
    Stack<Integer> working;

    /** Initialize your data structure here. */
    public MyQueue() {
        storage = new Stack<>();
        working = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        storage.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        relocateIfNeeded();
        return working.pop();
    }

    /** Get the front element. */
    public int peek() {
        relocateIfNeeded();
        return working.peek();
    }

    private void relocateIfNeeded() {
        if (working.isEmpty()) {
            while (!storage.isEmpty()) {
                working.push(storage.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return storage.isEmpty() && working.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */