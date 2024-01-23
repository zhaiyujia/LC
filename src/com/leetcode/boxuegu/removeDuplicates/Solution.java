package com.leetcode.boxuegu.removeDuplicates;

/**
 * @author zhai
 * @date 2024/1/23 12:50 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int i = 0;
        int j = 0;
        for(; i<nums.length;i++){
            if(i > 0 && nums[i] == nums[j]){
                continue;
            }else{
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int count = 0;
        int p = 0;
        for(int i=0;i<nums.length;i++){
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }
            nums[p++] = nums[i];
            count++;
        }
        return count;
    }

}
