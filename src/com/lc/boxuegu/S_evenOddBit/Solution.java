package com.lc.boxuegu.S_evenOddBit;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 50;
        int[] ints = solution.evenOddBit(n);
        System.out.println(ints.toString());
    }

    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for (int i = 0; n > 0; n >>= 1) {
            ans[i] += n & 1;
            i ^= 1;
        }
        return ans;
    }
}
