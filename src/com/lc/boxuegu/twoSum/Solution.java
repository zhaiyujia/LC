package com.lc.boxuegu.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhai
 * @date 2024/1/22 7:07 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        System.out.println(ints[0] + ", " + ints[1]);
    }


    // 暴力破解
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // 缓存解法，空间换时间
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(cache.containsKey(target - nums[i])){
                int j = target - nums[i];
                return new int[]{i, cache.get(j)};
            }
            cache.put(nums[i], i);
        }
        return null;    }

}
