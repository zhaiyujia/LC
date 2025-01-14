package com.lc.boxuegu.minOperations;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 10, 1, 3};
        int k = 10;
        int i = minOperations(nums, k);
        System.out.println(i);
    }


    public static int minOperations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            }
        }
        return count;
    }

}
