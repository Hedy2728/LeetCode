package leetcode409;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] ch = new int[256];
        for(char c : s.toCharArray()) {
            ch[c]++;
        }
        int res = 0;
        for(int i : ch) {
            if (i >= 2 && (i % 2) == 0) {
                res += i;
            } else if (i >=2 && (i % 2) == 1) {
                res += (i-1);
            }
        }

        if (res < s.length()) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("bananas"));
    }
}
