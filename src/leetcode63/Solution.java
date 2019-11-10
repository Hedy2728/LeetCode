package leetcode63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        System.out.println(m+" "+n);

        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        }
        else {
            dp[0][0] = 1;
        }

        for (int x = 1; x < m; x++) {
            if (obstacleGrid[x][0]==0){
                dp[x][0] = dp[x-1][0];
            }
            else {
                dp[x][0] = 0;
            }

        }

        for (int y = 1; y < n; y++) {
            if (obstacleGrid[0][y] == 0) {
                dp[0][y] = dp[0][y-1];
            }
            else {
                dp[0][y] = 0;
            }
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (obstacleGrid[x][y] == 1) {
                    dp[x][y] = 0;
                }
                else {
                    dp[x][y] = dp[x-1][y] + dp[x][y-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,0,0,0},{0,1,0,0},{0,0,0,0}};
        int[][] grid = {{1,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(grid));
    }
}
