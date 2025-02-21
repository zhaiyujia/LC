package com.lc.hot100.M_letterCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }


    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }

}
