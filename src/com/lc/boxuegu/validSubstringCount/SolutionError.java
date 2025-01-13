package com.lc.boxuegu.validSubstringCount;

public class SolutionError {

    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abc";
        long l = validSubstringCount(word1, word2);
        System.out.println(l);
    }

    public static long validSubstringCount(String word1, String word2) {
        int[] cnt1 = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            cnt1[word2.charAt(i) - 'a']++;
        }

        int[] cnt2 = new int[26];
        long ans = 0;
        for (int l = 0, r = 0; l < word1.length(); l++) {
            if (l > 0) {
                cnt2[word1.charAt(l - 1) - 'a']--;
            }

            while (!ok(cnt1, cnt2)) {
                if (r == word1.length()) {
                    return ans;
                }
                cnt2[word1.charAt(r++) - 'a']++;
            }

            ans += word1.length() - r + 1;

        }
        return ans;
    }

    public static boolean ok(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }

}
