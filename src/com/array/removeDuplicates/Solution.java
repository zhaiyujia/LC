package com.array.removeDuplicates;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2019/9/5 9:06
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        removeDuplicates(nums);

        double x = 77.77;
        double y = 3.0;
        System.out.println(x % y);


    }

    public static int removeDuplicates(int[] nums) {
//
//        if (nums.length == 0 || nums == null) {
//            return nums.length;
//        }
//
//        int i = 0;
//        int j = 0;
//
//        while (j<nums.length){
//            if(nums[i]==nums[j]){
//                j++;
//            }else{
//                i++;
//                nums[i] = nums[j];
//                j++;
//            }
//        }
//
//        return i+1;


        if(nums.length==0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;

//        int[] nn = new int[Integer.MAX_VALUE];
//        int index = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            nn[i]++;
//        }
//
//        for (int i = 0; i < nn.length; i++) {
//            if (nn[i] != 0) {
//                nums[index] = i;
//                index++;
//            }
//        }
//
//        return (index + 1);
    }

}
