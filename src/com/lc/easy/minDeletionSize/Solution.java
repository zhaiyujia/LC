package com.lc.easy.minDeletionSize;

/**
 * Created by zhaiyj
 * @author z
 * date 2019/11/11 9:07 上午
 */
public class Solution {

    public static void main(String[] args) {
        String [] A = {"cba", "daf", "ghi"};
        minDeletionSize(A);
    }

    public static int minDeletionSize(String[] A) {
        // cdg  bah afi
        int n = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length-1; j++) {
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    n++;
                    break;
                }
            }
        }
        return n;
    }
}
