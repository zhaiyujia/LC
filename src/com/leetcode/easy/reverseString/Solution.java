package com.leetcode.easy.reverseString;

/**
 * @author zhaiyj
 * @date 2019/4/18 9:02
 * @instruction 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */
public class Solution {

	public static void main(String[] args) {
//		char s []={'h','e','l','l','o'};
		char s[] = {'H', 'a', 'n', 'n', 'a', 'h'};

//		char s []={'H','a','c','d','a','h'};
		reverseString(s);
	}

	/**
	 * 输入：["h","e","l","l","o"]
	 * 输出：["o","l","l","e","h"]
	 * <p>
	 * 输入：["H","a","n","n","a","h"]
	 * 输出：["h","a","n","n","a","H"]
	 *
	 * @param s
	 */
	public static void reverseString(char[] s) {


		if (s == null || s.length <= 1) {
			return;
		}
		int l = 0, r = s.length - 1;
		char t;
		while (l < r) {
			t = s[l];
			s[l++] = s[r];
			s[r--] = t;
		}


//		int i = 0;
//		int j = s.length - 1;
//		while (i<j){
//			char temp = s[i];
//			s[i] = s[j];
//			s[j] = temp;
//			i++;
//			j--;
//		}


//		if (s == null){
//			return;
//		}
//		for (int i = 0; i < s.length; i++) {
//			int x = s.length / 2;
//			if (i == x){
//				break;
//			}
//			char temp = s[i];
//			s[i] = s[s.length - i - 1];
//			s[s.length - i - 1] = temp;
//		}
	}


}
