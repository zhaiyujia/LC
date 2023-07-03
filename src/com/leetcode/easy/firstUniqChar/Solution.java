package com.leetcode.easy.firstUniqChar;

/**
 * @author zhai
 * @date 2021/5/17 下午2:55
 * @illustration
 * @slogan:
 * @version: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 你可以假定该字符串只包含小写字母。
 */
public class Solution {

    public static void main(String[] args) {
        String s = "leetcode";
        int i = firstUniqChar2(s);
        System.out.println(i);
    }

    public static int firstUniqChar2(String s) {
        char[] ch = s.toCharArray();
        char[] chars = new char[26];
        for (int i = 0; i < ch.length; i++) {
            chars[ch[i] - 'a']++;
        }

        for (int i = 0; i < ch.length; i++) {
            if(chars[ch[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        char[] ch = s.toCharArray();
        char[] chars = new char[128];
        for (int i = 0; i < ch.length; i++) {
            chars[ch[i]]++;
        }

        for (int i = 0; i < ch.length; i++) {
            if(chars[ch[i]] == 1){
                return i;
            }
        }
        return -1;
    }


    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = 0;
            for (int j = 0; j < chars.length; j++) {
                if(i == j){
                    continue;
                }
                if (chars[i] == chars[j]) {
                    index++;
                    break;
                }

            }
            if (index == 0) {
                return i;
            }
        }
        return -1;
    }

}
