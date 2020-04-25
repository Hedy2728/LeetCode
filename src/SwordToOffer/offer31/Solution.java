package SwordToOffer.offer31;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (popA.length != pushA.length) {
            return false;
        }
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < pushA.length && j < popA.length) {
            stack.push(pushA[i++]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }
}
