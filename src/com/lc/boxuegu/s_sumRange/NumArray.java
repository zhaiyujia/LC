package com.lc.boxuegu.s_sumRange;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaiyj
 * @date 2025/4/25 20:36
 */
public class NumArray {


    private int[] ans;

    public NumArray(int[] nums) {
        this.ans = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ans[i + 1] = ans[i]  + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // right - left = (0 - right) - (0 - left)
        return ans[right + 1 ] - ans[left];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int i = numArray.sumRange(0, 5);
        System.out.println(i);
    }


}
