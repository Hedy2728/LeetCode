package leetcode494;
//qusiba 494 screw you fuck

public class Solution1 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum+S) % 2 == 1) {
            return 0;
        }
        int[] dp = new int[S+1];
//        dp[0] =
        return 1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {1,1,1,1,1};
        System.out.println(s.findTargetSumWays(nums, 3));
    }
}
