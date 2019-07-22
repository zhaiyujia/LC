package com.leetcode.matrixReshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/7/22 8:45
 * @description
 */
public class Solution {

    public static void main(String[] args) {

        String srt = "";

        System.out.println(srt.isEmpty());

        int[][] nums = {{1, 2, 3, 4}};
        int r = 2;
        int c = 2;
        int[][] res = matrixReshape(nums, r, c);
//        System.out.println(res);
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int size = nums.length * nums[0].length;
        if (size % (c*r) != 0) {
            return nums;
        }
        int index = 0;
        int coll = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] next = nums[i];
            for (int j = 0; j < next.length; j++) {
                int x = next[j];
                result[index][coll] = x;
                if(coll<c){
                    coll++;
                }

                if(coll==c){
                    coll=0;
                    index++;
                }
            }
        }
        return result;
        //        for (int i = 0; i < list.size(); i++) {
//            int x = list.get(i);
//            result[index][coll] = x;
//            if(coll<c){
//                coll++;
//            }
//
//            if(coll==c){
//                coll=0;
//                index++;
//            }
//        }
    }
}
