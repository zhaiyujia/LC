package com.leetcode.interview.a.hIndex;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2023/11/22 3:52 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("---------");
        t2();
        System.out.println("---------");
        t3();
        System.out.println("---------");
        t4();
        System.out.println("---------");
        t5();
    }


    private static void t1() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int i = hindex3(citations);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        int[] citations = new int[]{1, 3, 1};
        int i = hindex2(citations);
        System.out.println("t2:" + i);
    }

    private static void t3() {
        int[] citations = new int[]{2, 1};
        int i = hindex2(citations);
        System.out.println("t3:" + i);
    }

    private static void t4() {
        int[] citations = new int[]{100};
        int i = hindex2(citations);
        System.out.println("t4:" + i);
    }

    private static void t5() {
        int[] citations = new int[]{0};
        int i = hindex2(citations);
        System.out.println("t5:" + i);
    }

    public static int hindex3(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }


    public static int hindex2(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] < n - i) {
                break;
            }
            res++;
        }
        return res;
    }


    public static int hindex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;

        if (citations.length % 2 == 0) {
            max = citations[citations.length / 2 - 1];
        } else {
            max = citations[citations.length / 2];
        }
        return max;

    }

    public static int hIndex(int[] citations) {
        int result = 0;
        int max = citations[0];
        if (citations.length == 1 && citations[0] != 0) {
            return 1;
        }
        if (citations.length == 1) {
            return 0;
        }

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] == 0) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= citations[i]) {
                    count++;
                }
            }
            if (count > result) {
                max = citations[i];
                result = count;
            }
        }


        return max;
    }
}
