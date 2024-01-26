package com.lc.easy.islandPerimeter;

/**
 * @author zhaiyj
 * @date 2019/11/25 8:58 上午
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        islandPerimeter(grid);
    }


    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i=0;i<grid.length;i++){
            int[] g = grid[i];
            for (int j=0;j<g.length;j++){
                if(g[j] == 1){
                    int leftIdx = j - 1;
                    int rightIdx = j + 1;
                    int topIdx = i - 1;
                    int bottomIdx = i + 1;

                    if(leftIdx >=0){
                        if(g[leftIdx] == 0){
                            result++;
                        }
                    }else{
                        result++;
                    }

                    if(rightIdx < g.length){
                        if(g[rightIdx] == 0){
                            result++;
                        }
                    }else{
                        result++;
                    }

                    if(topIdx > 0){
                        if (grid[topIdx][j] == 0) {
                            result++;
                        }
                    }else{
                        result++;
                    }
                    if(bottomIdx < grid.length){
                        if(grid[bottomIdx][j] == 0){
                            result++;
                        }
                    }else {
                        result++;
                    }

                }
            }
        }
        return result;

//        int length = grid.length;
//        int width = grid[0].length;
//        int prm = 0;
//
//        // 把四个边的1去除，先计算里面
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < width; j++) {
//                if (grid[i][j] == 1) {
//                    if (j == 0 || grid[i][j - 1] == 0) {
//                        prm += 1;
//                    }
//                    if (i == 0 || grid[i - 1][j] == 0) {
//                        prm += 1;
//                    }
//                }
//            }
//        }
//        return prm * 2;
    }

}
