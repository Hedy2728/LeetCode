package leetcode448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[nums[i]-1] == nums[i]) {
                    break;
                }
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i+1)) {
                list.add(i+1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDisappearedNumbers(nums));
    }
}
