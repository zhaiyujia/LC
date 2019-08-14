package com.dp.minPathSum;

/**
 * @author zhaiyj
 * @date 2019/8/9 9:00
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        int le = grid.length;
        int size = grid[0].length;
        int[][] res = new int[le][size];
        for (int i = 0; i < le; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    res[0][0] = grid[i][j];
                } else if (i == 0 && j > 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                }else{
                    res[i][j] = Math.min(res[i][j - 1] + grid[i][j],res[i - 1][j] + grid[i][j]);
                }
            }
        }
        return res[le-1][size-1];
    }


}
