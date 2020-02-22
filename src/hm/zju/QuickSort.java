package hm.zju;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int i = left;
        int j = right;
        if (i > j) return;
        int temp = nums[i];
        while(i < j) {

            while (i < j && nums[j] <= temp) {
                j--;
            }

            while (i < j && nums[i] >= temp) {
                i++;
            }
            if (i < j) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }

        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);

    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 4, 6, 1, 9, 2, 3};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        for(int i :nums) {
            System.out.println(i);
        }
//        System.out.println(nums);
    }
}


