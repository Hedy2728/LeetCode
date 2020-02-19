package hm.zju.Sort;

public class HeapSort {

    public void heapSort(int[] nums) {
        for (int i = nums.length /2 -1; i >=0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums,0, j);
        }
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = i*2+1; k < length; k = k*2+1) {
            if (k+1<length && nums[k] < nums[k+1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            }
            else {
                break;
            }

        }
        nums[i] = temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
