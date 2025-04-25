package com.lc.boxuegu.m_subarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaiyj
 * @date 2025/4/25 19:54
 */
public class Solution {

    public static void main(String[] args) {


        int[] nums = new int[]{1, 1, 1};
        Solution solution = new Solution();
        solution.subarraySum(nums, 2);

    }


    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1); // 设置容量可以快 2ms
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum); // cnt[sj]++
        }
        return ans;

    }


}
