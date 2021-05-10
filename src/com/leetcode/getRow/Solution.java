package com.leetcode.getRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/12/10 9:10 上午
 */
public class Solution {

    public static void main(String[] args) {
        int rowIndex = 3;
        getRow(rowIndex);
    }


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long num = 1;
        for(int i=0; i<=rowIndex; i++){
            result.add((int)num);
            num = num*(rowIndex-i)/(i+1);
        }
        return result;
//        int size =rowIndex+1;
//        int[][] a = new int[size][size];
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            if (i == 0) {
//                a[i][0] = 1;
//            }
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == size - 1) {
//                    a[i][j] = 1;
//                } else {
//                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
//                }
//            }
//        }
//        int [] x = a[rowIndex];
//        for (int i : x) {
//            result.add(i);
//        }
//        return result;
    }

}
