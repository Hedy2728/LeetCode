package leetcode287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,5};
        System.out.println(s.findDuplicate(nums));
    }
}
