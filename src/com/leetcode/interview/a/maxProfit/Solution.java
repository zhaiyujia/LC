package com.leetcode.interview.a.maxProfit;

/**
 * @author zhai
 * @date 2023/11/7 5:05 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
    }

    private static void t1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println("t1:" + i);
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        int tmpMin = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < tmpMin) {
                tmpMin = price;
            } else {
                ans = Math.max(ans, price - tmpMin);
            }
        }

        return ans;
    }

}
