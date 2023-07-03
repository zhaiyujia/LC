package com.leetcode.easy.isSubsequence;

/**
 * ti
 *
 * @author zhai
 * @date 2021/5/18 上午10:10
 * @illustraon
 * @slogan:
 * @version: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isDP(s, t);
        System.out.println(subsequence);
    }

    public static boolean isDP(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a'){
                    f[i][j] = i;
                } else{
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        boolean result = false;
        int begin = 0;
        for (int i = 0; i < s1.length; i++) {
            char c = s1[i];
            boolean flag = false;
            while (begin < t1.length) {
                char c1 = t1[begin];
                begin++;
                if (c == c1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

}
