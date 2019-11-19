package com.leetcode.hammingWeight;

/**
 * @author zhaiyj
 * @date 2019/11/18 9:10 上午
 */
public class Solution {

    public static void main(String[] args) {
        int n = 11;
        hammingWeight(n);
    }

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;

//        int bits = 0;
//        int mask = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) {
//                bits++;
//            }
//            mask <<= 1;
//        }
//        return bits;
//        int count = 0;
//        String str = Integer.toBinaryString(n);
//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == '1'){
//                count++;
//            }
//        }
//        System.out.println(count);
//        return count;
    }

}
