package hm.zju.Sort;

public class MergeSort {
    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = (R-L) / 2 + L;
        sort(nums, L, mid);
        sort(nums, mid+1, R);
        merge(nums, L, mid, R);
    }

    private void merge(int[] nums, int L, int mid, int R) {
        int[] temp = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int i = 0;
        while(p1<=mid && p2 <= R) {
            temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1<=mid) {
            temp[i++] = nums[p1++];
        }
        while(p2 <= R) {
            temp[i++] = nums[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            nums[L+i] = temp[i];
        }
    }
}
