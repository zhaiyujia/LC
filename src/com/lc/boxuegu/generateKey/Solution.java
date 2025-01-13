package com.lc.boxuegu.generateKey;

public class Solution {


    public static void main(String[] args) {
        int num1 = 987, num2 = 879, num3 = 798;
        generateKey(num1, num2, num3);
    }

    public static int generateKey(int num1, int num2, int num3) {
        int a = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
        int b = Math.min(num1 % 100 / 10, Math.min(num2 % 100 / 10, num3 % 100 / 10));
        int c = Math.min(num1 % 1000 / 100, Math.min(num2 % 1000 / 100, num3 % 1000 / 100));
        int d = Math.min(num1 % 10000 / 1000, Math.min(num2 % 10000 / 1000, num3 % 10000 / 1000));
        return a + b * 10 + c * 100 + d * 1000;
    }


    public int generateKey1(int num1, int num2, int num3) {
        int key = 0;
        for (int p = 1; num1 > 0 && num2 > 0 && num3 > 0; p *= 10) {
            key += Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10) * p;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return key;
    }
}
