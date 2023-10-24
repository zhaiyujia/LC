package com.leetcode.interview.a.merge;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2023/10/24 3:38 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
//        t1();
//        System.out.println("------------");
//        t2();
//        System.out.println("------------");
//        t3();
//        System.out.println("------------");
//        t4();
        System.out.println("------------");
        t5();
    }

    private static void t1() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
//        merge(num1, 3, num2, 3);
        mergeV1(num1, 3, num2, 3);
        for (int i : num1) {
            System.out.println("t1:" + i);
        }
    }

    private static void t2() {
        int[] num1 = new int[]{1};
        int[] num2 = new int[]{0};
//        merge(num1, 1, num2, 0);
        mergeV1(num1, 1, num2, 0);
        for (int i : num1) {
            System.out.println("t2:" + i);
        }
    }

    private static void t3() {
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};
//        merge(num1, 0, num2, 1);
        mergeV1(num1, 0, num2, 1);
        for (int i : num1) {
            System.out.println("t3:" + i);
        }
    }

    private static void t4() {
        int[] num1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] num2 = new int[]{1, 2, 3};
//        merge(num1, 3, num2, 3);
        mergeV1(num1, 3, num2, 3);
        for (int i : num1) {
            System.out.println("t4:" + i);
        }
    }

    private static void t5() {
        int[] num1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] num2 = new int[]{1, 2, 2};
//        merge(num1, 3, num2, 3);
        mergeV2(num1, 6, num2, 3);
        for (int i : num1) {
            System.out.println("t5:" + i);
        }
    }

    public static void mergeV2(int[] nums1, int m, int[] nums2, int n){
        while (n>0 || m >0){
            
        }

        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p2 >= 0) { // nums2 还有要合并的元素
            // 如果 p1 < 0，那么走 else 分支，把 nums2 合并到 nums1 中
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
            } else {
                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
            }
        }
    }

    public static void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 1 && n == 0) {
            return;
        }

        if (m == 0 && n == 1) {
            nums1[0] = nums2[0];
            return;
        }

        for (int i = 0; i < nums2.length; i++) {
            int index = nums1.length - i - 1;
            nums1[index] = nums2[i];
        }

        Arrays.sort(nums1);
    }


}
