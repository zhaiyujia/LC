package com.leetcode.interview.a.productExceptSelf;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2023/11/23 6:39 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("---------");
        t2();
        System.out.println("---------");
    }


    private static void t1() {
        // 24,12,8,6
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = productExceptSelf3(nums);
        for (int anInt : ints) {
            System.out.println("t1:" + anInt);
        }
    }

    private static void t2() {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] ints = productExceptSelf3(nums);
        for (int anInt : ints) {
            System.out.println("t2:" + anInt);
        }
    }


    public static int[] productExceptSelf3(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int before = 1;
        int end = 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            ans[i] *= before;
            ans[j] *= end;
            before *= nums[i];
            end *= nums[j];
        }
        return ans;
    }

    public static int[] productExceptSelf2(int[] nums) {

        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] ans = new int[n];

        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = l[i] * r[i];
        }


        return ans;
    }


    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suf = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }

        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= suf;
            suf *= nums[j];
        }
        return ans;
    }


    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int z = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    z = z * nums[j];
                }
            }
            result[i] = z;
        }

        return result;
    }
}
