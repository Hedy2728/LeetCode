package leetcode215;

public class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            int res= nums[0];
            for (int i = nums.length/2-1; i >= 0; i--) {
                adjustHeap(nums, i, nums.length);
            }

            for (int i = nums.length-1; i >= 0; i--) {

                swap(nums, 0, i);

                adjustHeap(nums, 0, i);
                if (--k == 0) {
                    res = nums[i];
                }
            }
            return res;
        }
        private void adjustHeap(int[] nums, int i, int j) {
            int temp = nums[i];
            int lc = 2*i+1;
//            int rc = 2*(i+1);
            while (lc < j) {
                int rc = lc+1;
                if (rc < j && nums[rc] > nums[lc]) {
                    lc++;
                }
                if (lc < j && nums[lc] > temp) {
                    swap(nums, i, lc);
                }
                i = lc;
                lc = 2*lc+1;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

    public static void main(String[] args) {
        int[] nums = {2,1};
        int[] nums1 = {3,2,1,5,6,4};

        System.out.println(new Solution1().findKthLargest(nums1,2));
    }
}
