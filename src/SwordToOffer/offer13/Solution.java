package SwordToOffer.offer13;

public class Solution {
    /*本题使用回溯法来解决
    * 回溯法一半使用递归的方式来调用，注意边界的判断
    * 同时，将visited初始化为一维，是为了避免二维数组占用更大的空间，因为二维数组在堆中初始化的对象要更多*/
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCount(int threshold, int rows, int cols, int i, int j, boolean[] visited) {
        int res = 0;
        if (i >= 0 && i < rows && j >=0 && j < cols && computeIJ(i, j) <= threshold && !visited[i * cols + j]) {
            visited[i * cols + j] = true;
            res =  1 + movingCount(threshold, rows, cols, i + 1, j, visited) + movingCount(threshold, rows, cols, i, j + 1, visited)
                    + movingCount(threshold, rows, cols, i - 1, j, visited) + movingCount(threshold, rows, cols, i, j - 1, visited);
        }

        return res;
    }

    private int computeIJ(int i, int j) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i = i /10;
        }

        while (j > 0) {
            res += j % 10;
            j = j /10;
        }
        return res;
    }

    public static void main(String[] args) {
        int threshold = 4;
        int rows = 4, cols = 4;
        Solution s = new Solution();
        System.out.println(s.movingCount(threshold, rows, cols));
    }
}
