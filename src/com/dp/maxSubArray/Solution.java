package com.dp.maxSubArray;

/**
 * @author zhaiyj
 * @date 2019/7/29 8:58
 * @description
 * 最大子序列
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * DP法
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 分治法
     *
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        return maxSubArrayPart(nums, 0, nums.length - 1);
//    }
//
//    private static int maxSubArrayPart(int[] nums, int left, int right) {
//        if (left == right) {
//            return nums[left];
//        }
//        int mid = (left + right) / 2;
//        int leftNumber = maxSubArrayPart(nums, left, mid);
//        int rightNumber = Math.max(maxSubArrayPart(nums, mid + 1, right),
//                maxSubArrayAll(nums, left, mid, right));
//        return Math.max(leftNumber,rightNumber);
//    }
//
//    private static int maxSubArrayAll(int[] nums, int left, int mid, int right) {
//        int leftSum = Integer.MAX_VALUE;
//        int sum = 0;
//        for (int i = mid; i >= left; i--) {
//            sum += nums[i];
//            if (sum > leftSum) {
//                leftSum = sum;
//            }
//        }
//        sum = 0;
//        int rightSum = Integer.MAX_VALUE;
//        for(int i=mid+1;i<=right;i++){
//            sum+=nums[i];
//            if(sum>rightSum){
//                rightSum = sum;
//            }
//        }
//        return leftSum+rightSum;
//    }


}

