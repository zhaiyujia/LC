package com.leetcode.HammingDistance;

/**
 * @author zhaiyj
 * @date 2019/3/29 9:17
 * @instruction
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {

	public static void main(String[] args) {
		int result = hammingDistance(1,4);
		System.out.println(result);
	}

	/**
	 * 输入: x = 1, y = 4
	 * 输出: 2
	 * 解释:
	 * 1   (0 0 0 1)
	 * 4   (0 1 0 0)
	 *        ↑   ↑
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance(int x, int y) {

		int c = 0;
		if(x<y){
			c = y-x;
		}else{
			c = x-y;
		}
		String result = Integer.toBinaryString(c);
		return result.length();
	}


}
