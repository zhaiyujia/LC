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
        int[] ints = solution.twoSum2_3(nums, 9);
        System.out.println(ints[0] + ", " + ints[1]);
    }


    // 暴力破解
    public int[] twoSum1_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 缓存解法，空间换时间
    public int[] twoSum1_2(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                int j = target - nums[i];
                return new int[]{i, cache.get(j)};
            }
            cache.put(nums[i], i);
        }
        return null;
    }


    public int[] twoSum2_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2_2(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{i, cache.get(target - nums[i])};
            }
            cache.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2_3(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int complement = target - nums[left];
            if (cache.containsKey(complement)) {
                return new int[]{left, cache.get(complement)};
            } else {
                cache.put(nums[left], left);
            }

            complement = target - nums[right];
            if (cache.containsKey(target - nums[right])) {
                return new int[]{cache.get(complement), right};
            } else {
                cache.put(nums[right], right);
            }
            left++;
            right--;
        }
        return null;
    }


}
