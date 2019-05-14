package com.leetcode.NumJewelsInStones;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/3/19 9:13
 * @instruction 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class NumJewelsInStones {

	/**
	 * 输入: J = "aA", S = "aAAbbbb"  输出: 3
	 * <p>
	 * 输入: J = "z", S = "ZZ" 输出: 0
	 * <p>
	 * S 和 J 最多含有50个字母。 J 中的字符不重复。
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		int result = numJewelsInStones(J, S);
		System.out.println(result);
	}

	public static int numJewelsInStones(String J, String S) {

		if (S == null || J == null) {return 0;}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < J.length(); ++i) {
			set.add(J.charAt(i));
		}
		int ans = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (set.contains(S.charAt(i))) {
				ans++;
			}
		}
		return ans;

		/*int count = 0;
		if(J==null || S==null){
			return count;
		}

		char[] jChs = J.toCharArray();
		char[] sChs = S.toCharArray();
		int[] tChars = new int[127];
		for (int i = 0; i < sChs.length; i++) {
			tChars[sChs[i]]++;
		}

		for(int j=0;j<jChs.length;j++){
			count += tChars[jChs[j]];
		}

		return count;*/


/*		char [] s = new char[100];
		int counter = 0;
		for (int i = 0; i < J.length(); i++){
			s[i] = J.charAt(i);
		}
		for(int j = 0; j < S.length(); j++){
			for (int k = 0; k < J.length(); k++){
				if (s[k] == S.charAt(j)){
					counter++;
				}
			}
		}

		System.out.println(counter);
		return counter;*/
	}

}
