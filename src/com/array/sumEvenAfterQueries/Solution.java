package com.array.sumEvenAfterQueries;

import java.awt.geom.QuadCurve2D;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaiyj
 * @date 2019/8/29 9:05
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
//        sumEvenAfterQueries(A, queries);


    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int S = 0;
        for (int x : A) {
            if(x % 2 == 0){
                S += x;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index =  queries[i][1];
            if(A[index]%2==0){
                S -= A[index];
            }
            A[index] +=val;
            if(A[index]%2 ==0) {
                S += A[index];
            }
            ans[i] = S;
        }
        return ans;

//        int[] result = new int[A.length];
//        int sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 == 0) {
//                sum += A[i];
//            }
//        }
//
//        int size = queries.length;
//        for (int i = 0; i < size; i++) {
//            int x = queries[i][0];
//            int y = queries[i][1];
//            int temp = A[y];
//            A[y] = A[y] + x;
//            if (A[y] % 2 == 0) {
//                if(A[y] < 0){
//                    sum += x - temp;
//                }else{
//                    sum += A[y];
//                }
//            } else {
//                sum -= temp;
//            }
//            result[i] = sum;
//        }
//
//        return result;


//        int[] result = new int[A.length];
//        int size = queries.length;
//        for (int i = 0; i < size; i++) {
//            int x = queries[i][0];
//            int y = queries[i][1];
//            A[y] = A[y] + x;
//            int sum = 0;
//            for (int j : A) {
//                if (j % 2 == 0) {
//                    sum += j;
//                }
//            }
//            result[i] = sum;
//        }
//        return result;
    }


}
