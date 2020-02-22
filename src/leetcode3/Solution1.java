package leetcode3;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int tail = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer old = hashMap.get(s.charAt(i));
            hashMap.put(s.charAt(i), i);
            if (old != null && old > tail) {
                tail = old;
            }
            maxLen = Math.max(maxLen, i-tail);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
    }
}
