package com.lc.boxuegu.M_longestPalindrome;

public class Solution {

    public static void main(String[] args) {
        String s = "babad";
        Solution solution = new Solution();
        String s1 = solution.longestPalindrome2(s);
        System.out.println(s1);
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int maxLen = 1;
        char[] arr = s.toCharArray();

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (arr[i] == arr[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 >= maxLen) {
                        begin = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(begin, maxLen);
    }

    public String longestPalindrome(String s) {
        // i + 1 和  j - 1决定状态
        // 边界计算
        // s.length = 1 是
        // s.length = 2 && s1=s2 是
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


}
