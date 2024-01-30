package com.lc.boxuegu.removeDuplicates;

/**
 * @author zhai
 * @date 2024/1/23 12:50 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

//    public int removeDuplicates(int[] nums) {
//        if(nums == null){
//            return 0;
//        }
//        if(nums.length == 1){
//            return 1;
//        }
//        int count = 0;
//        int p = 0;
//        for(int i=0;i<nums.length;i++){
//            if(i> 0 && nums[i] == nums[i-1]){
//                continue;
//            }
//            nums[p++] = nums[i];
//            count++;
//        }
//        return count;
//    }

    public int removeDuplicates(int[] nums) {
        //特殊情况判断
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        //定义不重复元素的个数
        int count = 0;
        //定义不重复元素指针
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            nums[p++] = nums[i];
            count++;
        }
        return count;
    }


    public int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }


    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }


}
