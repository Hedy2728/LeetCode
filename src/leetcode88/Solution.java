package leetcode88;

import javax.swing.plaf.SliderUI;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i = m-1;
        int j = n-1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            }
            else {
                nums1[index--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }


    public static void main(String [] args) {
        int[] num1 = new int[10];
        num1[0] = 3;
        num1[1] = 6;
        num1[2] = 9;
        int[] num2 = {10, 11, 12};

        int m = 3;
        int n = 3;

        Solution mt = new Solution();
        mt.merge(num1, m, num2, n);

        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i] + " ");
        }

    }
}
