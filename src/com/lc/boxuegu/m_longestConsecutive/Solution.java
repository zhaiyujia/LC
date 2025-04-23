package com.lc.boxuegu.m_longestConsecutive;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaiyj
 * @date 2025/4/22 20:45
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }

    public int longestConsecutive1(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        for (int x : st) {
            if (st.contains(x - 1)) {
                continue;
            }

            int y = x + 1;
            while (st.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }

}
