package com.test;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0};
        int t = t(nums);
        System.out.println(t);
    }

    public static int t(int[] nums) {
        long sum = 0;
        int temp = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i] + temp;
            int right = (int) (sum - left);
            if(left > right){
                count++;
            }
            temp += nums[i];
        }
        return count;
    }

}
