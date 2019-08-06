package com.dynamicprogramming.rob;

import java.util.Objects;

/**
 * @author zhaiyj
 * @date 2019/8/5 9:00
 * @description
 */
public class Solution {

    public static void main(String[] args) {
//        int[] x = {0};
//        int res = rob(x);
//        System.out.println(res);

        Integer x = null;
        if(Objects.equals("null",x)){
            System.out.println("A");
        }

        String str = "null";
        System.out.println(String.valueOf(str));


    }

    public static int rob(int[] nums) {
//        int prevMax = 0;
//        int currMax = 0;
//        for (int x : nums) {
//            int temp = currMax;
//            currMax = Math.max(prevMax+x ,currMax);
//            prevMax = temp;
//        }
//        return currMax;

        int n = nums.length;
        if (n==0){
            return 0;
        }

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i-1]);
        }
        return memo[n];
    }
}
