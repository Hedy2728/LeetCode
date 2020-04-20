package leetcode416;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) != 0){
            return false;
        }

        int target = (sum >> 1);

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
     }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,2,3,5};
        System.out.println(s.canPartition(nums));
    }
}
