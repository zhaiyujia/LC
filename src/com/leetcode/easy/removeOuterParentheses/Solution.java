package com.leetcode.easy.removeOuterParentheses;

import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/5/14 8:59
 * @instruction
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 */
public class Solution {

	public static void main(String[] args) {
		String s = "(()())(())";
		removeOuterParentheses(s);
	}

	/**
	 * 输入："(()())(())"
	 * 输出："()()()"
	 * 解释：
	 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
	 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
	 *
	 *
	 * 输入："(()())(())(()(()))"
	 * 输出："()()()()(())"
	 * @param S
	 * @return
	 */
	public static String removeOuterParentheses(String S) {


		StringBuilder result = new StringBuilder(S);
		Stack<Character> stock = new Stack<>();
		for (int i = S.length()-1; i >= 0; i--) {
			if(S.charAt(i)==')'){
				if(stock.isEmpty()){
					result.deleteCharAt(i);
				}
				stock.add(S.charAt(i));
			}else {
				stock.pop();
				if(stock.isEmpty()){
					result.deleteCharAt(i);
				}
			}
		}
		return result.toString();



//		StringBuffer result = new StringBuffer();
//		char[] array = S.toCharArray();
//
//		int count = 0;
//		for (char c : array) {
//			if(c=='('){
//				count++;
//				if(count!=1){
//					result.append(c);
//				}
//			}else{
//				count--;
//				if(count!=0){
//					result.append(c);
//				}
//			}
//		}
//
//		return result.toString();

//		char[] chars = S.toCharArray();
//		String s = "";
//		LinkedList<Integer> list = new LinkedList<>();
//		int flag = 0;
//		int start = 0;
//		for (int i = 0; i < chars.length; i++) {
//			if (chars[i] == '('){
//				flag++;
//			}
//			if (chars[i] == ')'){
//				flag--;
//			}
//			if (flag == 0) {
//				list.add(i);
//			}
//		}
//		for (Integer i : list) {
//			s = s + S.substring(start + 1, i);
//			start = i + 1;
//		}
//		return s;


//		// 2个()中间 距离大于2 并且是偶数，一定能拆分
//		String result = "";
//		if (S==null || "".equals(S)){
//			return "";
//		}
//		int x=0;
//		int y=0;
//		int z=0;
//		for (int i = 0; i < S.length(); i++) {
//			if(S.charAt(i)=='('){
//				x++;
//			}
//			if(S.charAt(i)==')'){
//				y++;
//			}
//			if((i-z)>2 && (i-z)%2==1 && x==y && x>2 && y>2){
//				// 可拆分
//				for (int j = z+1; j < i; j++) {
//					result = result+S.charAt(j);
//				}
//				z=i+1;
//			}
//		}
//		return result;
	}

}
