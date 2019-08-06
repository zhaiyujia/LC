package com.dynamicprogramming.minCostClimbingStairs;

/**
 * @author zhaiyj
 * @date 2019/7/31 9:05
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int x = minCostClimbingStairs(cost);
        System.out.println(x);
    }

    public static int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}
