package leetcode41;

public class Solution {
    /*在一个未排序的数组中找出未出现的最小正整数，类似的题有448和442
    步骤如下：
    * 1、数组为null或者长度为0返回1
    * 2、遍历数组：找出数组是否包含数字1
    * 2.1、如果不包含1，返回1
    * 2.2、如果包含1，遍历数组，将小于等于0的数字和大于数组长度的数字置为1
    * 然后再次遍历数组，如果下标为正，则将出现过的数字对应的下标置为负
    * 再次扫描数组，返回第一次出现下标为正的数对应的索引+1*/
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1 && nums[0] == 1) {
            return 2;
        }

        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flag++;
            }
        }

        if (flag == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] = -nums[newIndex];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return   i+1;
            }
        }
        return nums.length+1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,1};
        System.out.println(s.firstMissingPositive(nums));
    }

}
