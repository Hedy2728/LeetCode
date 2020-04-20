package leetcode695;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.min(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i, j + 1);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i - 1, j);
        return num;
    }

    public int maxAreaOfIsland1(int[][] grid) {
        Stack<int[]> stack = new Stack<int[]>();
        int[][] array = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                stack.push(new int[]{i,j});
                int area = 0;
                while (!stack.isEmpty()) {
                    int[] cur = stack.pop();
                    int x = cur[0];
                    int y = cur[1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                        continue;
                    }
                    area++;
                    grid[x][y] = 0;
                    for (int[] temp : array) {
                        stack.push(new int[]{x+temp[0], y+temp[1]});
                    }

                }
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
