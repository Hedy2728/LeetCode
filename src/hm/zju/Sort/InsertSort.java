package hm.zju.Sort;

public class InsertSort {
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i-1;
            while(j >= 0) {
                if (nums[j] > temp) {
                    nums[j+1] = nums[j];
                    j--;
                }
                else {
                    break;
                }
            }
            nums[++j] = temp;
        }
    }
}
