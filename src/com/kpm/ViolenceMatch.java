package com.kpm;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2022/4/27 10:48 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class ViolenceMatch {

//    public int kmp(String s, String t) {
//        int m = s.length(), n = t.length();
//        int[] nextVal = new int[n];
//        getNext(t, nextVal);
//        int i = 0, j = 0;
//        while (i < m && j < n) {
//            if (j == -1 || s.charAt(i) == t.charAt(j)) {
//                i++;
//                j++;
//            } else j = nextVal[j];
//        }
//        if (j >= n) return i - n;
//        else return -1;
//    }
//
//    // 计算nextVal数组变化了
//    public void getNextVal(String t, int[] next) {
//        int j = 0, k = -1, n = t.length();
//        nextVal[0] = -1;
//        while (j < n - 1) {
//            if (k == -1 || t.charAt(j) == t.charAt(k)) {
//                j++;
//                k++;
//                if (t.charAt(j) != t.charAt(k)) nextVal[j] = k;
//                else nextVal[j] = nextVal[k];
//            } else k = nextVal[k];
//        }
//    }
}
