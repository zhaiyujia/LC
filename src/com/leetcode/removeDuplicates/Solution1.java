package com.leetcode.removeDuplicates;

/**
 * @author zhai
 * @date 2021/5/10 下午4:58
 * @illustration
 * @slogan:
 * @version:
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates1(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    /**
     * 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[right] == nums[right - 1]){
                count++;
            }else{
                nums[right - count] = nums[right];
            }
        }
        return nums.length - count;
    }



}
