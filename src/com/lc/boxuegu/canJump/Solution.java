package com.lc.boxuegu.canJump;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean t = canJump(nums);
        System.out.println(t);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        int len = nums.length;
        int last = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
