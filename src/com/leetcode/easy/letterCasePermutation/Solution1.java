package com.leetcode.easy.letterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/11/29 8:45 上午
 */
public class Solution1 {

    public static void main(String[] args) {
        String S = "a1b2";
        List<String> res = letterCasePermutation1(S);
        System.out.println(res.size());
    }

    public static List<String> letterCasePermutation1(String S) {
        List<String> ans = new ArrayList();
        int B = 0;
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                B++;
            }
        }

        for (int bits = 0; bits< 1<<B; bits++){
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter : S.toCharArray()){
                if(Character.isLetter(letter)){
                    if(((bits >> b++) & 1) == 1) {
                        word.append(Character.toLowerCase(letter));
                    }else{
                        word.append(Character.toUpperCase(letter));
                    }
                }else{
                    word.append(letter);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }



    public static List<String> letterCasePermutation(String S) {

        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c : S.toCharArray()){
            int n = ans.size();
            if(Character.isLetter(c)){
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            }else{
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }
        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans){
            finalans.add(sb.toString());
        }
        return finalans;
    }

    public static List<String> dfs(int start, int l, String S,List<String> res, String temp){
        if (start >= l || temp.length() == l) {
            res.add(temp);
            return res;
        }
        char word = S.charAt(start);
        if (word >= '0' && word <= '9') {
            dfs(start + 1, l, S, res, temp + word);
        } else if (word >= 'a' && word <= 'z') {
            dfs(start + 1, l, S, res, temp + word);
            dfs(start + 1, l, S, res, temp + (word + 32));
        } else if (word >= 'A' && word <= 'Z') {
            dfs(start + 1, l, S, res, temp);
            dfs(start + 1, l, S, res, temp + (word - 32));
        }
        return res;
    }

}
