package com.lc.boxuegu.M_findKthLargest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2025/5/15 22:36
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k ];
    }

}
