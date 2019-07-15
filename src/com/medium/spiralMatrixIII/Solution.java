package com.medium.spiralMatrixIII;

/**
 * @author zhaiyj
 * @date 2019/7/12 9:07
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        spiralMatrixIII(1, 4, 0, 0);
    }


    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        /**
         * 总共R * C 个长度
         */
        int[][] points = new int[R * C][2];
        int size = R * C;
        // 直线最大步数
        int max = 1;
        // 纵向走开始位置
        int col_start = r0;
        // 横向走开始位置
        int row_start = c0;
        points[0][0] = r0;
        points[0][1] = c0;
        int len = 1;
        // 当前位置
        int row = r0;
        int col = c0;
        boolean isNet = true;

        while (len < size) {
            // 向右走,行不变 列+1
            for (int j = 1; j <= max; j++) {
                row = col_start;
                col = j + row_start;
                isNet = row >= 0 && row < R && col >= 0 && col < C;
                if (isNet) {
                    points[len][0] = row;
                    points[len++][1] = col;
                }
            }
            row_start += max;
            // 向下走,列不变，行+1
            for (int j = 1; j <= max; j++) {
                row = j + col_start;
                col = row_start;
                isNet = row >= 0 && row < R && col >= 0 && col < C;
                if (isNet) {
                    points[len][0] = row;
                    points[len++][1] = col;
                }
            }
            col_start += max;
            max++;

            // 向左走 行不变 列-1
            for(int j=1;j<=max;j++){
                row = col_start;
                col = row_start - j;
                isNet = row >= 0 && row < R && col >= 0 && col < C;
                if (isNet) {
                    points[len][0] = row;
                    points[len++][1] = col;
                }
            }
            row_start -= max;
            // 向上走 列不变 行-1
            for(int j=1;j<max;j++){
                row = col_start - j;
                col = row_start;
                isNet = row >= 0 && row < R && col >= 0 && col < C;
                if (isNet) {
                    points[len][0] = row;
                    points[len++][1] = col;
                }
            }
            col_start -= max;
            max++;
        }
        return points;
    }


}
