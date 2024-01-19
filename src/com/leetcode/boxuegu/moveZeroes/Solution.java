package com.leetcode.boxuegu.moveZeroes;

/**
 * @author zhai
 * @date 2024/1/19 9:53 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes1(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes1(int[] nums) {
        int i = 0;
        int j = 0;
        for (;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }


    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != 0 ){
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < nums.length){
            nums[j] = 0;
            j++;
        }
    }


}
