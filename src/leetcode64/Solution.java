package leetcode64;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = grid[i][j]+dp[i][j-1];
                else if (j == 0) dp[i][j] = grid[i][j]+dp[i-1][j];
                else dp[i][j] = Math.min(grid[i][j] + dp[i-1][j], grid[i][j] + dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));
    }
}
