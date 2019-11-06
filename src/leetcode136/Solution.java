package leetcode136;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {

        int[] flag = new int[nums.length];
        for (int p = 0; p < flag.length; p++) {
            flag[p] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        flag[i] = 1;
                        flag[j] = 1;
                        break;
                    }
                }
            }

            }
        int res=0;
        for (int p = 0; p < flag.length; p++) {
            if (flag[p] == 0){
                res = nums[p];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(new Solution().singleNumber(arr));
    }
}
