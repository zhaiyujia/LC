package com.lc.boxuegu.removeDuplicates1;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,2,2,3};
        solution.removeDuplicates1(nums);
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }

    public int removeDuplicates1(int[] nums) {
        int slow = 2;
        for(int fast = 2; fast<nums.length;fast++){
            if(nums[fast] != nums[slow - 2]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }



}
