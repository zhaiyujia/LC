package com.lc.hot100.S_singleNumber;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 1};
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }


    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
