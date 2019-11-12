package leetcode633;

public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int i=0;
        int j = (int)Math.sqrt(c);
        while (i < j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            }
            else if (sum < c) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(10));
    }
}
