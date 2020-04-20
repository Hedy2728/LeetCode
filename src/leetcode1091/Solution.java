package leetcode1091;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }
        grid[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[][] dir = {{1,0}, {1,1}, {1,-1}, {0,1}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}};
        int len = queue.size();
        int c = 0; //计算某一层次的节点是否已经遍历完毕，即与queue的长度len进行比较
        int res = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            if (x == m-1 && y == n-1) {
                return res;
            }

            for (int[] d : dir) {
                int xt = x + d[0];
                int yt = y + d[1];
                if (xt >= 0 && yt >= 0 && xt < m && yt < n && grid[xt][yt] == 0) {
                    queue.add(new int[]{xt, yt});
                    grid[xt][yt] = 1;
                }
            }
            c++;
            if (c == len) {
                c = 0;
                len = queue.size();
                res++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0,1,1,1},{1,0,0,1},{0,1,1,0},{1,0,0,0},{1,1,1,0}};
        System.out.println(s.shortestPathBinaryMatrix(grid));

    }
}

