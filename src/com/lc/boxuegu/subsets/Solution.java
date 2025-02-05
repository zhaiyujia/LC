package com.lc.boxuegu.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets1(nums);
        System.out.println(subsets.toString());
    }



    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        for(int i = (int) Math.pow(2, n); i < Math.pow(2, n + 1); i++){
            String bitMask = Integer.toBinaryString(i).substring(1);
            List<Integer> cur = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(bitMask.charAt(j) == '1'){
                    cur.add(nums[j]);
                }
            }
            result.add(cur);
        }

        return result;
    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[curr]);
        dfs(curr + 1, nums);
        t.remove(t.size() - 1);
        dfs(curr + 1, nums);

    }




}
