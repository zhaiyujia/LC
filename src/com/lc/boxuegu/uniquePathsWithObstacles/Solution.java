package com.lc.boxuegu.uniquePathsWithObstacles;

public class Solution {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        Solution solution = new Solution();
        int i = solution.uniquePathsWithObstacles1(obstacleGrid);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0 ;i < m;i ++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 0 ;i < n;i ++){
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }


        for(int i = 1 ; i < n;i ++){
            for(int j = 1  ;j < m;j ++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

}
