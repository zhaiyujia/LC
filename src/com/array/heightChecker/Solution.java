package com.array.heightChecker;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2019/8/27 8:54
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        heightChecker(heights);
    }

    public static int heightChecker(int[] heights) {
        int[] arr = new int[heights.length + 1];
        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                int x = heights[j++];
                if (x != i) {
                    count++;
                }
            }
        }
        return count;
//        int result = 0;
//        int size = heights.length;
//        int[] sum = new int[size];
//        for (int i = 0; i < size; i++) {
//            sum[i] = heights[i];
//        }
//
//        Arrays.sort(sum);
//        for (int i = 0; i < size; i++) {
//            int he = heights[i];
//            if(he != sum[i]){
//                result++;
//            }
//        }
//        return result;
    }


}
