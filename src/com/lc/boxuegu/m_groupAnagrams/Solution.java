package com.lc.boxuegu.m_groupAnagrams;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2025/4/21 21:20
 */
public class Solution {


    public static void main(String[] args) {
        String[] str = new String[]{"ddddddddddg", "dgggggggggg"};
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(str);
        System.out.println(lists.size());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            // s 相同的字符串分到同一组
            m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(m.values());
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        // 使用as码校验
        int length = strs.length;

        // 存储全部的ASCII码
        Map<int[], Integer> map = new HashMap<>();
        // list<Int[]>
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 计算as码
            // 存储aslist
            int[] cache = new int[26];
            String word = strs[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                // ASCII 码存映射
                cache[c - 'a'] += 1;
            }
            map.put(cache, i);
            lists.add(cache);
        }

        // 计算那些ASCII码得出结果都是0

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<String> child = new ArrayList<>();
            int[] ints = lists.get(i);
            if (!map.containsKey(ints)) {
                continue;
            }
            for (int j = 0; j < lists.size(); j++) {
                int[] intj = lists.get(j);
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (ints[k] - intj[k] != 0) {
                        // 表示两个字母字母顺序一致， 可以增加到一个集合中
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (map.containsKey(intj)) {
                        child.add(strs[map.get(intj)]);
                        map.remove(intj);
                    }
                }
            }
            result.add(child);
        }
        return result;
    }

}
