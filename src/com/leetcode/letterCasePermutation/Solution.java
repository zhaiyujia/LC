package com.leetcode.letterCasePermutation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/7/5 8:49
 * @instruction 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class Solution {

	public static void main(String[] args) {
		String s = "a1b2";
		letterCasePermutation(s);
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		int l = S.length();
		if (l == 0) {
			return res;
		}
		dfs(0, l,S,res,"");
		return res;
	}


	private static List<String> dfs(int start, int l, String S, List<String> res, String temp) {
		// 已经找到答案
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
