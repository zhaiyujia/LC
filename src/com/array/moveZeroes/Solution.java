package com.array.moveZeroes;

/**
 * @author zhaiyj
 * @date 2019/9/3 9:06
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }


//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size - i - 1; j++) {
//                if(nums[j] == 0){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] =temp;
//                }
//            }
//        }
    }

}
