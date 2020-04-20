package SwordToOffer.offer9;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    /*这一题有一点疑问，当stack1和stack2的元素均为空时，应该抛出异常queue is empty，但是在牛客里面不用处理这个异常*/
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        /*
        if (stack2 == null) {
            throw new Exception("queue is empty");
        }
         */
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        System.out.println(s.pop());
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
