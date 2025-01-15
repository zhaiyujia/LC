package com.lc.boxuegu.minOperations1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{69,89,57,31,84,97,50,38,91,86};
        int k = 91;
        int i = minOperations(nums, k);
        System.out.println(i);
    }

    public static int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= k) {
                break;
            }
            min = Math.min(min, nums[i]) * 2 + Math.max(min, nums[i]);
            count++;
            if (min >= k) {
                min = 0;
            }
        }

        return count;
    }

}
