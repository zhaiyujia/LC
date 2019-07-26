package com.dynamicprogramming.maxProfit;

/**
 * @author zhaiyj
 * @date 2019/7/26 9:45
 * @description
 */
public class TestArray {

    public static void main(String[] args) {
        int[] x = {12,324,125,121,2321,421,5213,51,21,213213};
        int max = 0;
        int min = x[0];
        for (int i = 0; i < x.length; i++) {
            max = Math.max(max,x[i]);
            min = Math.min(min,x[i]);
        }
        System.out.println("max:"+max);
        System.out.println("min:"+min);
    }
}
