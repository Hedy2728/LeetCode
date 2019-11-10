package leetcode53;

/*this is for solving the begin and end position of thr maxSubArray ,
* and it is the existence of dp array that we can confirm the start position and mark the flag whether it's 0 or 1
* */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = 0;
        int flag = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            }
            else{
                dp[i] = nums[i];
                flag = 0;
            }
            if (dp[i] > sum) {
                sum = dp[i];
                if ((flag++) == 0) {
                    start =i;
                }
                end = i;
            }
        }
        System.out.println("start = "+start);
        System.out.println("end = "+end);
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-21,2};
        int[] nums = {-4, -1, -2, 2};
        System.out.println(new Solution1().maxSubArray(nums));
    }
}
