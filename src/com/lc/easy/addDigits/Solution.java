package com.lc.easy.addDigits;

/**
 * @author zhaiyj
 * @date 2019/5/23 9:13
 * @instruction 加数字
 * 这道题让我们求数根，所谓树根，就是将大于10的数的各个位上的数字相加，
 * 若结果还大于10的话，则继续相加，直到数字小于10为止。
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
