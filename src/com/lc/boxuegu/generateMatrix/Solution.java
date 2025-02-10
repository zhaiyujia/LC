package com.lc.boxuegu.generateMatrix;

public class Solution {

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        int[][] ints = solution.generateMatrix2(n);
        System.out.println(ints);
    }

    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];

        int cur = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while(cur <= n * n) {
            int i = rowBegin;
            int j = colBegin;
            //left to right
            for(j = colBegin ; j <= colEnd; j++){
                res[rowBegin][j] = cur++;
            }
            rowBegin++;
            //top to bot
            for(i = rowBegin ; i <= rowEnd; i++){
                res[i][colEnd] = cur++;
            }
            colEnd--;
            //right to left
            for(j = colEnd ; j >= colBegin; j--){
                res[rowEnd][j] = cur++;
            }
            rowEnd--;
            //bot to top
            for(i = rowEnd; i >= rowBegin; i--){
                res[i][colBegin] = cur++;
            }
            colBegin++;
        }
        return res;
    }

    public int[][] generateMatrix1(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }

            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }

                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

}
