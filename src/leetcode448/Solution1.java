package leetcode448;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /*找到数组中消失的数*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] = -nums[newIndex];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDisappearedNumbers(nums));
    }
}
