package com.leetcode.easy.shortestToChar;

/**
 * @author zhaiyj
 * @date 2019/5/13 9:06
 * @instruction 给定一个字符串 S 和一个字符 C。返回一个代表字符串
 * S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 */
public class Solution {
	static String s;
	static  char c;
	static Integer max = Integer.MAX_VALUE;
	public static void main(String[] args) {

		String str = "eaaaaaeaeeeadea";
		char c = 'e';
		shortestToChar(str, c);
	}

	/**
	 * 输入: S = "loveleetcode", C = 'e'
	 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
	 *
	 * @param S
	 * @param C
	 * @return
	 */
	public static int[] shortestToChar(String S, char C) {
		int[] res = new int[S.length()];
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i)!=C){
				res[i]=S.length();
			}else{
				res[i]=0;
				int j = i-1;
				int minDis = 1;
				while (j>=0 && S.charAt(j)!=C){
					if(minDis<res[j]){
						res[j--] = minDis++;
					}else{
						break;
					}
				}

				int k = i + 1;
				minDis = 1;
				while (k<S.length() && S.charAt(k)!=C){
					res[k++]=minDis++;
				}
				i = k - 1;
			}
		}
		return res;
	}


//	public static int[] shortestToChar(String S, char C) {
//		int[] re = new int[S.length()];
//		s = S;
//		c = C;
//		int max = Integer.MAX_VALUE;
//		if(S==null || "".equals(S)){
//			return new int[1];
//		}
//
//		for (int i = 0; i < s.length(); i++) {
//			char curr = s.charAt(i);
//			if(curr==c){
//				re[i]=0;
//			}else{
//				int count = max;
//				if(i>0){
//					count = Math.min(count,searchLeft(i));
//				}
//				if(i<s.length()-1){
//					count = Math.min(count,searchRight(i));
//				}
//				re[i]=count;
//			}
//		}
//		return re;
//	}

	private static int searchLeft(int i) {
		int count = 0;
		for (int j = i - 1; j >= 0; j--) {
			char curr = s.charAt(j);
			count++;
			if (curr == c) {
				return count;
			}
		}
		return max;
	}

	private static int searchRight(int i) {
		int count = 0;
		for (int j = i + 1; j < s.length(); j++) {
			char curr = s.charAt(j);
			count++;
			if (curr == c) {
				return count;
			}
		}
		return max;
	}

}
