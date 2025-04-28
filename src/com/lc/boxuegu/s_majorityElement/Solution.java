package com.lc.boxuegu.s_majorityElement;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2025/4/28 20:34
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        Solution solution = new Solution();
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }


    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int x = nums.length / 2;
        int count = 0;
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (pre == nums[i]) {
                count++;
                if (count > x) {
                    return pre;
                }
            } else {
                pre = nums[i];
                count = 1;
            }
        }
        return pre;
    }

}
