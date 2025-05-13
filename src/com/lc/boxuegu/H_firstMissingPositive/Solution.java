package com.lc.boxuegu.H_firstMissingPositive;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2025/5/13 20:33
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(nums);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前学生的学号在 [1,n] 中，但（真身）没有坐在正确的座位上
            while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int j = nums[i-1];
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 找第一个学号与座位编号不匹配的学生
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 所有学生都坐在正确的座位上
        return n + 1;
    }


//    public int firstMissingPositive(int[] nums) {
//       int[] max = new int[Integer.MAX_VALUE];
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] < 0){
//                continue;
//            }
//            max[i] += 1;
//        }
//
//        for (int i = 0; i < max.length; i++) {
//            if(nums[i] == 0){
//                return i;
//            }
//        }
//        return 0;
//    }


}
