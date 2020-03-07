package leetcode344;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start++, end--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : s) {
            linkedList.add(c);
        }
        Collections.reverse(linkedList);
        System.out.println(linkedList);
        new Solution().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
