package hm.zju.Sort;

public class HeapSort {
    private int[] nums;
    public HeapSort(int[] nums) {
        this.nums= nums;
        heapSort();
    }
    public void heapSort() {
        for (int i = nums.length /2 -1; i >=0; i--) {
            adjustHeap(i);
        }
    }

    private void adjustHeap(int i) {
        int l = ((i+1)<<1) -1;
        int r = (i+1) << 1;

        int small = i;
        if (l < nums.length && nums[i] > nums[l]) {
            small = l;
        }

        if (r < nums.length && nums[r] < nums[small]) {
            small = r;
        }
        if (i == small) {
            return;
        }

        swap(nums, i , small);
        adjustHeap(small);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] getNums() {
        return nums;
    }
}
