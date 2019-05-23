package com.leetcode.addDigits;

/**
 * @author zhaiyj
 * @date 2019/5/23 9:13
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		int x = 138;
		int result = addDigits(x);
		System.out.println(result);
	}

	public static int addDigits(int num) {

		return 1 + (num - 1) % 9;


//		if(num>9){
//			num = num%9;
//			if(num==0){
//				return 9;
//			}
//		}
//		return num;
	}

}
