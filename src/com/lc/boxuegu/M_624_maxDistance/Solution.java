package com.lc.boxuegu.M_624_maxDistance;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>());
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); ++i) {
            List<Integer> arr = arrays.get(i);
            int a = Math.abs(arr.get(arr.size() - 1) - min);
            int b = Math.abs(max - arr.get(0));


            ans = Math.max(ans, Math.max(a, b));
            min = Math.min(min, arr.get(0));
            max = Math.max(max, arr.get(arr.size() - 1));
        }
        return ans;
    }
}
