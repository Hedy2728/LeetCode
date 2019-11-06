package leetcode136;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(new Solution2().singleNumber(arr));
    }
}
