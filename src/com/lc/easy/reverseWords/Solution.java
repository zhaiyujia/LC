package com.lc.easy.reverseWords;


/**
 * @author zhaiyj
 * @date 2019/4/25 8:59
 * @instruction 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Solution {

	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		String result = reverseWords(str);
		System.out.println(result);
	}

	/**
	 * 输入: "Let's take LeetCode contest"
	 * 输出: "s'teL ekat edoCteeL tsetnoc"
	 *
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
//		StringBuffer result = new StringBuffer();
//		String[] words = s.split(" ");
//		for (int i = 0; i < words.length; i++) {
//			String word = words[i];
//			for(int j=word.length() -1 ;j>=0;j--){
//				result.append(word.charAt(j));
//			}
//			if(i!=words.length -1){
//				result.append(" ");
//			}
//		}
//		return result.toString();
		char[] letters = s.toCharArray();
		int i = 0;
		while (i<s.length()){
			int j = s.indexOf(' ',i+1);
			if(j == -1){
				j = s.length();
			}
			reverse(letters, i, j);
			i = j+1;
		}
		return String.valueOf(letters);

	}

	private static void reverse(char[] letters, int begin, int end) {
		int length = end - begin;
		int mid = begin + length/2;
		char temp;
		for(int i=begin, k=end-1;i<mid;i++,k--){
			temp = letters[i];
			letters[i] = letters[k];
			letters[k] = temp;
		}

	}

}
