package hm_test.java_test2;

import java.util.Stack;

public class stack2_queue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public void queue_in(int data) {
        stack1.push(data);
    }

    public int queue_out() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                int data = stack1.peek();
                stack2.push(data);
                stack1.pop();
            }


        }
        if (stack2.size() == 0) {
            System.out.println("the queue is empty!");
        }

        int res = stack2.peek();
        stack2.pop();
        return res;
    }

    public static void main(String[] args) {
        stack2_queue s2q = new stack2_queue();
        s2q.queue_in(1);
        s2q.queue_in(2);
        s2q.queue_in(3);
        System.out.println(s2q.queue_out());
        s2q.queue_in(4);
        System.out.println(s2q.queue_out());
    }
}
