package leetcode442;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] < 0) {
                list.add(Math.abs(newIndex + 1));
            } else {
                nums[newIndex] = -nums[newIndex];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDuplicates(nums));
    }
}
