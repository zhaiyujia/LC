package com.leetcode.easy.findComplement;

/**
 * @author zhaiyj
 * @date 2019/4/8 9:10
 * @instruction
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 注意:
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 */
public class FindComplement {

	public static void main(String[] args) {
		findComplement(5);
	}

	public static int findComplement(int num) {
		int temp = num;
		int c = 0;
		while (temp>0){
			temp >>= 1;
			c = (c << 1) + 1;
		}
		return num ^ c;
	}

}
