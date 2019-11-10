package leetcode53;

import java.util.Arrays;
//only concentrate on nums which are have positive numbers, it's not suitable for the array which are all the negative
public class Solution3 {
    public static int[] maxSubArray(int a[]) {
        int[] result = new int[3];
        int sum = 0, flag = 0;
        result[2] = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > result[2]) {
                result[2] = sum;
                if ((flag++) == 0)
                    result[0] = i;
                result[1] = i;
            } else if (sum < 0) {
                sum = 0;
                flag = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-21,2};
        int[] nums = {-4, -1, -2};
//        System.out.println(new Solution1().maxSubArray(nums));
        System.out.println(Arrays.toString(new Solution3().maxSubArray(nums)));
    }
}
