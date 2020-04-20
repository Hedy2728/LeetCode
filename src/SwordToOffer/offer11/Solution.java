package SwordToOffer.offer11;

public class Solution {
    /*这种解法太精妙了
    * 我的想法是通过二分查找确定mid在前半段还是在后半段，然后当s与e相差1时输出，但是这样不能解决特殊情况{1,0,1,1,1}
    * 借鉴https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?answerType=1&f=discussion
    * 不做s与e相差1的判断，反而是让start++，在while循环开始时判断是否是一个递增序列，这样就可以解决特殊情况
    * 真是坑多啊*/
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (start < end) {
            if (array[start] < array[end]) {
                return array[start];
            }

            mid = start + (end - start) / 2;
            if (array[mid] > array[start]) {
                start = mid + 1;
            } else if (array[mid] < array[end]) {
                end = mid;
            } else {
                start++;
            }
        }
        return array[start];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int[] array = {1,0,1,1,1};
        System.out.println(array.length);
        System.out.println(s.minNumberInRotateArray(array));
    }
}
