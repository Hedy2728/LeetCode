package leetcode136;

import java.util.HashSet;

public class Solution3 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }
        for (int i : set) {
            result = i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(new Solution3().singleNumber(arr));
    }
}
