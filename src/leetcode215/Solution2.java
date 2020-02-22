package leetcode215;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length-1;

        while (true) {
            int position = partition(nums, left, right);
            if (position == k-1) {
                return nums[position];
            } else if (position > k-1) {
                right = position - 1;
            } else {
                left = position + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int l = left+1;
        int r = right;
        int pivot = left;
        while (l <= r) {
            while (l <= r && nums[r] <= nums[pivot]) {
                r--;
            }
            while (l <= r && nums[l] >= nums[pivot]) {
                l++;
            }
//            if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
//
//            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, pivot, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution2().findKthLargest(nums, 4));
    }
}
