package leetcode213;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int i, int j) {
        int pre = 0, cur = 0, tmp;
        for (int m = i; m < j; m++) {
            tmp = cur;
            cur = Math.max(pre+nums[m], cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(s.rob(nums));
    }
}
