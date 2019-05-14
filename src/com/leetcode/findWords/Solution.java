package com.leetcode.findWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/4/19 8:52
 * @instruction
 */
public class Solution {


	public static void main(String[] args) {
		String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
		findWords(words);
	}

	public static String[] findWords(String[] words) {
		List<String> res = new ArrayList<>();
		String one = "qwertyuiopQWERTYUIOP";
		String two = "asdfghjklASDFGHJKL";
		String third = "zxcvbnmZXCVBNM";

		for (String word : words) {
			String now = "";
			if(one.indexOf(word.charAt(0))!=-1){
				now = one;
			}
			if(two.indexOf(word.charAt(0))!=-1){
				now = two;
			}
			if(third.indexOf(word.charAt(0))!=-1){
				now = third;
			}

			boolean flag = true;
			for(int i=0;i<word.length();i++){
				if(now.indexOf(word.charAt(i)) == -1){
					flag = false;
				}
			}
			if(flag){
				res.add(word);
			}
		}
		return res.toArray(new String[]{});


//		String[] keyboard = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
//		List<String> ans = new ArrayList<>();
//
//		for (String s : words) {
//			ans.add(s);
//		}
//
//		for (int i = 0; i < words.length; i++) {
//
//			int keyFirst = 0;
//			for (int j = 0; j < keyboard.length; j++) {
//				if (keyboard[j].indexOf(words[i].charAt(0)) != -1) {
//					keyFirst = j;
//					break;
//				}
//			}
//
//			for (int j = 1; j < words[i].length(); j++) {
//				if (keyboard[keyFirst].indexOf(words[i].charAt(j)) == -1) {
//					ans.remove(words[i]);
//					break;
//				}
//			}
//		}
//		return ans.toArray(new String[ans.size()]);
	}
}
