package leetcode151;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        s = s.trim();
        System.out.println(s.length());
        int len = s.length();
        int end = len;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i > 0; i--) {

            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, end)).append(' ');
                while (s.charAt(i - 1) == ' ') {
                    i--;
                }
                end = i;
            }
        }
        sb.append(s.substring(0, end));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  hello   world!";
//        String[] ss = s.split(" ");
//        for (String t : ss) {
//            System.out.println(t);
//        }
        System.out.println(new Solution().reverseWords(s));
        System.out.println(new Solution().reverseWords(s).length());
    }
}
