package com.lc.boxuegu.M_minimumSize;

public class Solution {

    // https://leetcode.cn/circle/discuss/0viNMK/
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,8,2};
        int maxOperations = 4;
        Solution solution = new Solution();
        int i = solution.minimumSize(nums, maxOperations);
        System.out.println(i);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = 0;
        for (int num : nums) {
            r = Math.max(num, r);
        }

        while (l < r){
            int mid = (l + r) >> 1;
            int total = 0;
            for (int num : nums) {
                total += (num - 1) / mid;
            }
            if (total <= maxOperations){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }


}
