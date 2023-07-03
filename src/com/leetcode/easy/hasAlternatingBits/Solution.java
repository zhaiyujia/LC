package com.leetcode.easy.hasAlternatingBits;

/**
 * @author zhaiyj
 * @date 2019/6/21 8:43
 * @instruction 给定一个正整数，检查他是否为交替位二进制数：
 * 换句话说，就是他的二进制数相邻的两个位数永不相等。
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(16));
//		int n = 7;
//		boolean flag = hasAlternatingBits(n);
//		System.out.println(flag);
	}

	/*
	5=0101

   0101     n
^  0010     n>>1
_____________________
   0111     7
&  1000     8
____________________
   0000     0


7=0111

   0111
^  0011
____________________
   0100      4
&  0101      5
________________________
   0100      4
	 */

	public static boolean hasAlternatingBits(int n) {

		while (n != 0) {
			int k = n & 1;
			n >>= 1;
			if ((n & 1) == k) {
				return false;
			}
		}
		return true;



//		int temp = n ^ (n>>1);
//		int re = temp & (temp+1);
//		return re==0;


//		String str = Integer.toBinaryString(n);
//		int size = str.length();
//		for (int i = 0; i < size-1; i++) {
//			char c = str.charAt(i);
//			char next = str.charAt(i+1);
//			if((c^next) != 1){
//				return false;
//			}
//		}
//		return true;



//		String str = Integer.toBinaryString(n);
//		int size = str.length();
//		for (int i = 0; i < size-1; i++) {
//			char c = str.charAt(i);
//			char next = str.charAt(i+1);
//			if(c==next){
//				return false;
//			}
//		}
//		return true;
	}


}
