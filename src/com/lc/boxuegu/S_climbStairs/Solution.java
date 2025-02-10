package com.lc.boxuegu.S_climbStairs;

public class Solution {

    public static void main(String[] args) {
        int n = 2;

        Solution solution = new Solution();
        int i = solution.climbStairs(n);
        System.out.println(i);

    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
