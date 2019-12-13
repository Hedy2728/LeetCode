package hm.zju.Sort;

import javax.swing.plaf.SliderUI;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*
        1、冒泡排序是将两个数比较，接替向后走，最后一个则是最大的数，反之亦然
        2、插入排序从1号位开始，比0号位小的则插入0号位，存在着一个数组向后挪的过程，需要一个temp存储当前访问的num
        3、堆排序则利用了最大堆或者最小堆的特点，每次交换之后必须重新建立大顶堆或者小顶堆；
        4、归并排序是利用二分的思想，将数据一半一半的分开，并使其有序，再小的有序数组合并成大的有序数组
        5、选择排序是一次又一次的将最小的数选择出来，与冒泡的思想类似
        6、快速排序是利用分治的思想，选择0号位作为基准，左指针与右指针分别找到比0号位大和比0号位小的数字，并进行交换，并且需要注意终止条件
         */
        int[] nums = {2,1,3,4,5};
//        new BubbleSort().Bubble(nums); //冒泡排序
//        new InsertSort().insertSort(nums); //插入排序
//        nums = new HeapSort(nums).getNums(); // 堆排序
//        new MergeSort().mergeSort(nums); // 归并排序
//        new SelectSort().selectSort(nums); // 选择排序
        new QuickSort().quickSort(nums, 0, nums.length-1); //快速排序
        System.out.println(Arrays.toString(nums));

    }
}
