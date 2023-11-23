package com.leetcode.interview.a.canJump;

/**
 * @author zhai
 * @date 2023/11/9 5:37 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("-------");
        t2();
    }

    private static void t1() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean b = canJump(nums);
        System.out.println("t1:" + b);
    }

    private static void t2() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println("t2:" + b);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= count) {
                count++;
            } else {
                count = 0;
            }
        }
        return count == 0;
    }


}
