package com.lc.easy.maxProfit;

/**
 * @author zhai
 * @date 2021/5/10 下午6:12
 * @illustration
 * @slogan:
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                continue;
            }
            profit = profit + prices[i + 1] - prices[i];
        }
        return profit;
    }
}
