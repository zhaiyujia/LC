package com.lc.easy.rotate;

/**
 * @author zhai
 * @date 2021/5/10 下午6:40
 * @illustration
 * @slogan:
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    // [5,6,7,1,2,3,4]
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int value = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = value;
        }
    }

}
