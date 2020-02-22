package leetcode3;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ret = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                ret = Math.max(ret, set.size());
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "qrsvbspk";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
