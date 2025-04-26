package com.lc.boxuegu.m_maxSubArray;

/**
 * @author zhaiyj
 * @date 2025/4/26 18:42
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        Solution solution = new Solution();
        int i = solution.maxSubArray(nums);
        System.out.println(i);
    }


    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int f = 0;
        for(int x : nums){
            f = Math.max(f,0) + x;
            ans = Math.max(ans, f);
        }
        return ans;
    }


    public int maxSubArray3(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int ans = f[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1], 0) + nums[i];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x;
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }


    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }


        return 0;
    }


}
