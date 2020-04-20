package leetcode378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j= 0; j < matrix[0].length; j++) {
//                pq.offer(matrix[i][j]);
//                if (pq.size() > k) {
//                    pq.poll();
//                }
//            }
//        }
//        return pq.peek();
//    }


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];

        while (low < high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    }
                }
            }
            if (count < k) {
                low = mid + 1;

            } else {
                high = mid;
            }
        }
        return low;
    }

//    public int kthSmallest(int[][] matrix, int k) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int left = matrix[0][0];
//        int right = matrix[row - 1][col - 1];
//        while (left < right) {
//            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
//            int mid = (left + right) / 2;
//            // 找二维矩阵中<=mid的元素总个数
//            int count = findNotBiggerThanMid(matrix, mid, row, col);
//            if (count < k) {
//                // 第k小的数在右半部分，且不包含mid
//                left = mid + 1;
//            } else {
//                // 第k小的数在左半部分，可能包含mid
//                right = mid;
//            }
//        }
//        return right;
//    }
//
//    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
//        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
//        int i = row - 1;
//        int j = 0;
//        int count = 0;
//        while (i >= 0 && j < col) {
//            if (matrix[i][j] <= mid) {
//                // 第j列有i+1个元素<=mid
//                count += i + 1;
//                j++;
//            } else {
//                // 第j列目前的数大于mid，需要继续在当前列往上找
//                i--;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,5,9},{10,11,13},{12,14,15}};
        System.out.println(s.kthSmallest(matrix, 8));
    }
}
