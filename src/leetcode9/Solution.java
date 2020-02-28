package leetcode9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 101;
        System.out.println(new Solution().isPalindrome(i));
    }
}
