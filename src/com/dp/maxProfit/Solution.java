package com.dp.maxProfit;

/**
 * @author zhaiyj
 * @date 2019/7/26 8:57
 * @description
 * 买股票
 */
public class Solution {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        int last = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            last = Math.max(0, last + prices[i+1] - prices[i]);
            profit = Math.max(profit, last);
        }
        return profit;


//        int minprice = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minprice)
//                minprice = prices[i];
//            else if (prices[i] - minprice > maxprofit)
//                maxprofit = prices[i] - minprice;
//        }
//        return maxprofit;


//        int max = 0;
//        int min = prices[0];
//        for (int i = 0; i < prices.length; i++) {
//            max = Math.max(max, prices[i] - min);
//            min = Math.min(min,prices[i]);
//        }
//        return max;


//        int x = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            int temp = 0;
//            int one = prices[i];
//            for (int j = i + 1; j < prices.length; j++) {
//                int two = prices[j];
//                if (two - one > 0) {
//                    temp = two - one;
//                    if(temp>x){
//                        x = temp;
//                    }
//                }
//            }
//        }
//        return x;


//        int[] result = new int[prices.length];
//        for (int i = 0; i < prices.length - 1; i++) {
//            int temp = 0;
//            int one = prices[i];
//            for (int j = i + 1; j < prices.length; j++) {
//                int two = prices[j];
//                if (two - one > 0) {
//                    temp = two - one;
//                    if(temp>result[i]){
//                        result[i] = temp;
//                    }
//                }
//            }
//        }
//
//        int max = result[0];
//        //遍历数组
//        for (int i = 0; i < result.length; i++) {
//            //判断大小
//            if (result[i] > max) {
//                max = result[i];
//                System.out.println("最大值是：" + max);
//            }
//        }
//        return max;
    }

}
