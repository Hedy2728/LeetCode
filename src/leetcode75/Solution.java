package leetcode75;

public class Solution {
    public void sortColors(int[] nums) {
         int less = -1;
         int i = 0;
         int more = nums.length;

         while (i < more) {
             if (nums[i] == 0) {
                 swap(nums, ++less, i++);
             }
             else if (nums[i] == 2) {
                 swap(nums, --more, i);
             }
             else {
                 i++;
             }
         }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
