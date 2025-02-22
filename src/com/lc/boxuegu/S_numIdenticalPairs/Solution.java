package com.lc.boxuegu.S_numIdenticalPairs;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,2,1};
        int i = solution.numIdenticalPairs(nums);
        System.out.println(i);
    }

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            int c = cnt.getOrDefault(x, 0);
            ans += c;
            cnt.put(x, c + 1);
        }
        return ans;
    }


    public int numIdenticalPairs1(int[] nums) {
        int ant = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ant++;
                }
            }
        }
        return ant;
    }


}
