package leetcode232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
