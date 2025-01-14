package com.lc.boxuegu.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring1(String s) {

        int max = 0;
        int len = s.length();

        for (int l = 0, r = 1; l < len; l++) {
            char c = s.charAt(l);
            Set<Character> set = new HashSet<>();
            set.add(c);
            while (l < r) {
                // 有重复数据了
                if (set.contains(s.charAt(r))) {
                    l++;
                    r++;
                    set.remove()
                    break;
                }
                set.add(s.charAt(r));
                r++;
            }
        }


        return max;
    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Set<Character> set = new HashSet<>();
            char c = s.charAt(i);
            set.add(c);
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}

