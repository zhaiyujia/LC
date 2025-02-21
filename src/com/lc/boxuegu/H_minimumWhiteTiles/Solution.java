package com.lc.boxuegu.H_minimumWhiteTiles;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String floor = "10110101";
        int numCarpets = 2;
        int carpetLen = 2;
        int i = solution.minimumWhiteTiles(floor, numCarpets, carpetLen);
        System.out.println(i);
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] memo = new int[numCarpets + 1][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(numCarpets, m - 1, floor.toCharArray(), memo, carpetLen);
    }

    private int dfs(int i, int j, char[] floor, int[][] memo, int carpetLen) {
        if (j < carpetLen * i) { // 剩余砖块可以全部覆盖
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = dfs(i, j - 1, floor, memo, carpetLen) + (floor[j] - '0');
        if (i > 0) {
            res = Math.min(res, dfs(i - 1, j - carpetLen, floor, memo, carpetLen));
        }
        return memo[i][j] = res; // 记忆化
    }


}
