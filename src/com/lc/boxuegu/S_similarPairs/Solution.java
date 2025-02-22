package com.lc.boxuegu.S_similarPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String [] words = new String[]{"aba","aabb","abcd","bac","aabc"};
        Solution solution = new Solution();
        solution.similarPairs(words);
    }

    public int similarPairs(String[] words) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int c = cnt.getOrDefault(mask, 0);
            ans += c;
            cnt.put(mask, c + 1);
        }
        return ans;
    }

}
