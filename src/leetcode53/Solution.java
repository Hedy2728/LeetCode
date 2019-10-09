package leetcode53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int size = nums.length;

        for (int i = 1; i <= size; i++) { //i is sum size
            for (int j = 0; j < size; j++) { //j is the begin location of sum
                int s = nums[j];
                for (int p = j+1; p < i; p++) { //p is for sum
                    s += nums[p];
                }
                if (s > sum ) {
                    sum = s;
                }

            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-1,-3};
        System.out.println(sl.maxSubArray(nums));
    }
}
