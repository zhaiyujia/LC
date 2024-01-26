package com.lc.easy.UniqueMorseRepresentations;

import java.util.HashSet;

/**
 * @author zhaiyj
 * @date 2019/3/25 8:55
 * @instruction
 * 国际摩尔斯密码定义一种标准编码方式，
 * 将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 */
public class UniqueMorseRepresentations {

	public static void main(String[] args) {

		String[] words = new String[]{"gin", "zen", "gig", "msg"};
		int a = uniqueMorseRepresentations(words);
		System.out.println(a);
	}

	/**
	 * 例如:
	    输入: words = ["gin", "zen", "gig", "msg"]
	    输出: 2
	    解释:
	    各单词翻译如下:
		 "gin" -> "--...-."
		 "zen" -> "--...-."
	     "gig" -> "--...--."
	     "msg" -> "--...--."

	 共有 2 种不同翻译, "--...-." 和 "--...--.".
	 * @param words
	 * @return
	 */
	public static int uniqueMorseRepresentations(String[] words) {

		String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		HashSet<String> set = new HashSet<String>();
		for (int i=0;i<words.length;i++){
			String word  = words[i];
			StringBuffer stringBuffer = new StringBuffer();
			for (char c: word.toCharArray()) {
				stringBuffer.append(mos[c - 'a']);
			}
			set.add(stringBuffer.toString());
		}
		return set.size();
	}

}
