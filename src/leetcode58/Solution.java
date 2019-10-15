package leetcode58;

public class Solution {

    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length()-1;

        if (s == "" || s == null) {
            return count;
        }
        while (i>=0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord(""));
    }
}
