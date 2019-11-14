package leetcode680;

public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        int flag = 0;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 != c2) {
                if (flag == 0) {
                    if (s.charAt(i+1) == c2) {
                        i++;
                        flag = 1;
                    }
                    else if (s.charAt(j-1) == c1) {
                        j--;
                        flag =1;
                    }
                    else {
                        return false;
                    }

                }
                else {
                    return false;
                }
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abada"));
    }
}
