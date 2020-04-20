package SwordToOffer.offer21;

import java.util.Arrays;

public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        int start = 0;

        while (start < len) {
            int end = start + 1;
            if ((array[start] & 1) == 0) {
                while ((array[end] & 1) == 0) {
                    if (end >= len-1) {
                        return;
                    }
                    end++;
                }
                int temp = array[end];
                int count = end - start;
                while (count > 0) {
                    array[end] = array[end-1];
                    count--;
                    end--;
                }
                array[start] = temp;
            }
            start++;
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3,4,5,6};
        s.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
