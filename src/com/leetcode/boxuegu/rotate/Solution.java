package com.leetcode.boxuegu.rotate;

/**
 * @author zhai
 * @date 2024/1/25 7:45 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        solution.rotate(nums, 3);
    }


    // 正解
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start< end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }




    // 超时
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return;
        }

        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
