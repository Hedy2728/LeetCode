package leetcode215;
import hm.zju.MinHeap.MinHeap;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] topk = new int[k];

        for (int i = 0; i < k; i++) {
            topk[i] = nums[i];
        }
        MinHeap heap = new MinHeap(topk);
        for (int i = k; i < nums.length; i++) {
            int root = heap.getRoot();
            if (nums[i] > root) {
                heap.setRoot(nums[i]);
            }
        }
        return nums[nums.length-k-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution().findKthLargest(nums, 4));
    }
}
