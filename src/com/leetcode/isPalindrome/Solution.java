package com.leetcode.isPalindrome;

/**
 * @author zhaiyj
 * @date 2019/7/15 8:50
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int x = 1231;
        boolean flag = isPalindrome(x);
        System.out.println(flag);
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }

        return x == temp || x == temp / 10;


//        int temp = x;
//        if(x<0){
//            return false;
//        }
//
//        int rev = 0;
//        while(x != 0){
//            int pop = x % 10;
//            x = x / 10;
//            rev = rev * 10 + pop;
//        }
//
//
//
//        if((temp ^ rev) == 0){
//            return true;
//        }
//
//        return false;
    }
}
