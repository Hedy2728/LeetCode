package leetcode494;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findTargetSumWays(nums, 0, S);
    }

    public int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return findTargetSumWays(nums, start+1, S+nums[start]) + findTargetSumWays(nums, start+1, S-nums[start]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,1,1};
        System.out.println(s.findTargetSumWays(nums, 3));
    }
}
