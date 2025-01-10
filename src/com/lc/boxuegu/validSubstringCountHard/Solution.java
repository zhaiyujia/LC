package com.lc.boxuegu.validSubstringCountHard;

public class Solution {

    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abc";
        long l = validSubstringCount(word1, word2);
        System.out.println(l);
    }

    public static long validSubstringCount1(String word1, String word2) {
        long res = 0L;
        int[] tgt = new int[26];
        char[] ch2 = word2.toCharArray();
        for (char i : ch2) {
            tgt[i - 'a']++;
        }

        int len = word1.length();
        //滑窗
        int[] cnt = new int[26];
        for (int i = 0, l = 0; i < word1.length(); i++) {
            cnt[word1.charAt(i) - 'a']++;
            //如果当前滑窗 包含 目标所需成份，就要加结果了
            while (check(cnt, tgt)) {
                //加的结果数是 当前i到len-1 这些个右端点
                res = res + (len - 1 - i + 1);

                cnt[word1.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;

    }

    public static boolean check(int[] cnt, int[] tgt) {
        for (int i = 0; i < 26; i++) {
            if (tgt[i] > cnt[i])
                return false;
        }
        return true;
    }


    public static long validSubstringCount(String word1, String word2) {
        int[] cnt1 = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            cnt1[word2.charAt(i) - 'a']++;
        }

        int[] cnt2 = new int[26];
        int ans = 0;
        for (int l = 0, r = 0; l < word1.length(); l++) {
            if (l > 0) {
                cnt2[word1.charAt(l - 1) - 'a']--;
            }

            while (!ok(cnt1, cnt2)) {
                if (r == word1.length()) {
                    return ans;
                }
                cnt2[word1.charAt(r) - 'a']++;
                r++;
            }

            ans = ans + (word1.length() - 1 - l + 1);

        }
        return ans;
    }

    public static boolean ok(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > cnt2[i]) {
                return false;
            }
        }
        return true;
    }


}
