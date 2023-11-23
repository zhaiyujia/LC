package com.leetcode.interview.a.maxProfit;

/**
 * @author zhai
 * @date 2023/11/9 4:59 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution1 {


    public static void main(String[] args) {
        t1();
        System.out.println("-----");
        t2();
        System.out.println("-----");
        t3();
    }

    private static void t1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        int[] prices = new int[]{1,2,3,4,5};
        int i = maxProfit(prices);
        System.out.println("t2:" + i);
    }


    private static void t3() {
        int[] prices = new int[]{7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println("t3:" + i);
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }


}
