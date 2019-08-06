package com.dp.climbStairs;

/**
 * @author zhaiyj
 * @date 2019/7/30 8:53
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int n = 10;
        int x = climbStairs(n);
        System.out.println(x);
    }

    public static int climbStairs(int n) {
        // 动态规划
//        if(n<=2){
//            return n;
//        }
//
//        int x = 1;
//        int y = 2;
//        for (int i = 3; i <= n; i++) {
//            int temp = x + y;
//            x = y;
//            y = temp;
//        }
//        return y;


        // 直接递归超时,重复计算
//        if (n == 1) {
//            return 1;
//        }
//        if(n==2){
//            return 2;
//        }
//        else{
//            return climbStairs(n-1) + climbStairs(n-2);
//        }
        climb_Stairs(0, n);

        int memo[] = new int[n + 1];
        climb_Stairs(0, n, memo);

        return 0;
    }

    /**
     * 斐波那契序列算法，数量大时，会有误差
     * @param n
     * @return
     */
    public static int fibSqrt(int n) {
//        dobule sqrt5 = Math.sqrt(5);
//        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
//        return (int) (fibn / sqrt5);
        return 0;
    }


    /**
     * binets 数学算法
     *
     * @param n
     * @return
     */
    public static int binets(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {1, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiplay(ret, a);
            }
            n >>= 1;
            a = multiplay(a, a);
        }
        return ret;
    }

    public static int[][] multiplay(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }


    /**
     * 斐波那契序列
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 1) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int dp(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 暴力法
     *
     * @param i
     * @param n
     * @return
     */
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    /**
     * 递归记忆法
     *
     * @param i
     * @param n
     * @param memo
     * @return
     */
    private static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }


}
