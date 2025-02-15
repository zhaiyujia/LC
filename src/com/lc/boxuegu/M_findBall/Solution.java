package com.lc.boxuegu.M_findBall;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,-1,1,-1,-1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        Solution solution = new Solution();
        int[] ball = solution.findBall1(grid);
        System.out.println(ball.toString());
    }

    public int[] findBall1(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int curCol = j;
            for (int[] row : grid) {
                int d = row[curCol];
                curCol += d;
                // 如果球出界或者卡在 V 形，退出循环，否则继续循环（垂直落入下一排）
                // V 形就是 -1 的左边是 1，1 的右边是 -1，即 row[curCol] != d
                if (curCol < 0 || curCol == n || row[curCol] != d) {
                    curCol = -1;
                    break;
                }
            }
            ans[j] = curCol;
        }
        return ans;
    }


    // errir
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid.length];
        // grid[i][j] 为 1 或 -1
        int j = 0;
        for (int i = 0; i < grid.length; i++) {
            while (j <= grid[0].length) {
                // 第一个小球的特殊判断
                if (i == 0 && grid[i][j] == -1) {
                    ans[i] = -1;
                    break;
                }
                // 当前位置向左，判断前一个位置是否是右，如果是、右，则是V型，出不去
                if (grid[i][j] == -1 && grid[i - 1][j] == 1) {
                    ans[i] = -1;
                    break;
                }

                // 当前位置向右，判断后一个位置是否向左，如果是左，则是V型，出不去
                if (grid[i][j] == 1 && grid[i + 1][j] == -1) {
                    ans[i] = -1;
                    break;
                }
                j++;
            }
            ans[i] = grid[i][j];
        }
        return ans;
    }

}
