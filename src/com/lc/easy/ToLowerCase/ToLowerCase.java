package com.lc.easy.ToLowerCase;

/**
 * @author zhaiyj
 * @date 2019/3/20 9:12
 * @instruction
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
 * 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class ToLowerCase {

	public static void main(String[] args) {
		String str = toLowerCase("AFSFsjakdlsjd");
		System.out.println(str);
	}

	/**
	 * 输入: "Hello"
	 输出: "hello"
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str) {
		return str.toLowerCase();
	}

}
