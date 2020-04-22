package leetcode20;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || (c == ']' || c =='}')) {
                if (stack.isEmpty()) {
                    return false;
                }
                char st = stack.pop();
                if ((c == ')' && st != '(') || (c == ']' && st != '[') || (c =='}' && st != '{')) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "{}[][()]";
        System.out.println(s.isValid(str));
    }
}
