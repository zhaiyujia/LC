package com.lc.boxuegu.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String s = "abcbbcbb";
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {

//        int max = 0;
//        int len = s.length();
//
//        for (int l = 0, r = 1; l < len; l++) {
//            char c = s.charAt(l);
//            Set<Character> set = new HashSet<>();
//            set.add(c);
//            while (l < r) {
//                // 有重复数据了
//                if (set.contains(s.charAt(r))) {
//                    l++;
//                    r++;
//                    set.remove()
//                    break;
//                }
//                set.add(s.charAt(r));
//                r++;
//            }
//        }
//
//
//        return max;
        return 0;
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

