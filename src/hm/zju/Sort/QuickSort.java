package hm.zju.Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums, int low, int high){
        if (nums.length == 0 || nums == null || low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int flag = nums[low];
        while (i < j) {
            while (nums[j] >= flag && j > i) {
                j--;
            }
            while (nums[i] <= flag && j > i) {
                i++;
            }
            if (i < j) {
                swap(nums[j], nums[i]);
            }
        }
        nums[low] = nums[i];
        nums[i] = flag;

        quickSort(nums, low, i-1);
        quickSort(nums, i+1, high);
    }

    private void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3,6};
        new QuickSort().quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
