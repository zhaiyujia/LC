package com.lc.easy.canWinNim;

/**
 * Created by zhaiyj
 * date 2019/11/8 9:16 上午
 */
public class Solution {

    public static void main(String[] args) {
        int n = 4;
        boolean b = canWinNim(10);
        System.out.println(b);

    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
