package com.lc.boxuegu.waysToSplitArray;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,-20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30,-31,-32,-33,-34,-35,-36,-37,-38,-39,-40,-41,-42,-43};
        int i = waysToSplitArray(nums);
        System.out.println(i);
    }

    public static int waysToSplitArray(int[] nums) {
        long sum = 0;
        long temp = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            long left = nums[i] + temp;
            long right = sum - left;
            if (left >= right) {
                count++;
            }
            temp += nums[i];
        }
        return count;
    }


}
