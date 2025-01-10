package com.lc.boxuegu.validSubstringCount;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abc";
        long l = validSubstringCount(word1, word2);
        System.out.println(l);
    }


    public static long validSubstringCount(String word1, String word2) {
        int[] dic = new int[26];
        int count = 0;

        for (int i = 0; i < word2.length(); i++) {
            if (dic[word2.charAt(i) - 'a']-- == 0) {
                count++;
            }
        }

        int left = 0;
        long ans = 0;

        for (int right = 0; right < word1.length(); right++) {
            if (++dic[word1.charAt(right) - 'a'] == 0) {
                count--;
            }
            while (count == 0) {
                ans += 0l + word1.length() - right;
                if (--dic[word1.charAt(left++) - 'a'] < 0) {
                    count++;
                    break;
                }
            }
        }
        return ans;

    }


    private static boolean ok(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public static long validSubstringCount1_1(String word1, String word2) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
        }
        long ans = 0;
        for (int l = 0, r = 0; l < word1.length(); l++) {
            if (l > 0) {
                cnt1[word1.charAt(l - 1) - 'a']--;
            }
            while (!ok(cnt1, cnt2)) {
                if (r == word1.length()) {
                    return ans;
                }
                cnt1[word1.charAt(r++) - 'a']++;
            }
            ans += word1.length() - r + 1;
        }
        return ans;
    }

    public static long validSubstringCount_ERROR(String word1, String word2) {
        List<String> list = new ArrayList<>();
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String str = word1.substring(i, j);
                if (str.length() < word2.length()) {
                    continue;
                }
                list.add(str);
            }
        }


        Map<Character, Long> maps = new HashMap<>();
        for (String input : list) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (maps.containsKey(c)) {
                    Long aLong = maps.get(c);
                    aLong++;
                    maps.put(c, aLong);
                } else {
                    maps.put(c, 1L);
                }
            }
        }

        Map<Character, Long> word2Map = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            if (word2Map.containsKey(c)) {
                Long aLong = word2Map.get(c);
                aLong++;
                word2Map.put(c, aLong);
            } else {
                word2Map.put(c, 1L);
            }
        }
        final long[] count = {0};
        word2Map.forEach((k, v) -> {
            if (!maps.containsKey(k)) {
                return;
            }

            Long aLong = maps.get(k);
            if (aLong != v) {
                return;
            }
            count[0]++;
        });


        return count[0];
    }

}
