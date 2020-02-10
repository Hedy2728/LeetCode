package leetcode150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int num1 = 0, num2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (s.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (s.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
