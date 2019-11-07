package com.leetcode.balancedStringSplit;

/**
 * Created by zhaiyj
 * date 2019/11/7 9:17 上午
 */
public class Solution {

    public static void main(String[] args) {
        String s = "RLRRLLLLRL";
        balancedStringSplit(s);
    }

    public static int balancedStringSplit(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='R'){
                n++;
            }
            if(s.charAt(i) == 'L'){
                n--;
            }
            if(n == 0){
                num++;
            }
        }
        return num++;
    }

}
