package com.array.relativeSortArray;

/**
 * @author zhaiyj
 * @date 2019/8/28 9:08
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        relativeSortArray(arr1, arr2);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int[] cnt = new int[1001];
        for (int n : arr1) {
            cnt[n]++;
        }
        int i =0;
        for (int n : arr2) {
            for (int j = 0; j < cnt[n]; j++) {
                res[i++] = n;
            }
            cnt[n] = 0;
        }

        for (int j = 0; j <= 1000; j++) {
            for (int k = 0; k < cnt[j]; k++) {
                res[i++] = j;
            }
        }
        return res;


//        int[] result = new int[arr1.length];
//        int[] arr3 = new int[1001];
//        for (int i : arr1) {
//            arr3[i]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i < arr2.length; i++) {
//            int temp = arr2[i];
//            while (arr3[temp]-->0){
//                result[index] = temp;
//                index++;
//            }
//        }
//
//        for (int i = 0; i < arr3.length; i++) {
//            if(arr3[i]>0){
//                while (arr3[i]-->0){
//                    result[index] = i;
//                    index++;
//                }
//            }
//        }
//        return result;
    }

}
