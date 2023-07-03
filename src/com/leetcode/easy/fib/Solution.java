package com.leetcode.easy.fib;

/**
 * @author zhaiyj
 * @date 2019/4/24 9:00
 * @instruction 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 */
public class Solution {

	public static void main(String[] args) {
		int result = fib(3);
		System.out.println(result);
	}

	/**
	 * 输入：2
	 * 输出：1
	 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
	 * <p>
	 * 输入：3
	 * 输出：2
	 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
	 * <p>
	 * 输入：4
	 * 输出：3
	 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
	 *
	 * @param N
	 * @return
	 */
	public static int fib(int N) {

		int[] cache = new int[N + 1];
		return fibcall(N, cache);

//		if (N < 2) {
//			return N;
//		}
//		int r = 0;
//		int first = 0;
//		int second = 1;
//
//		for (int i = 2; i <= N; i++) {
//			r = first + second;
//			first = second;
//			second = r;
//		}
//		return r;


//		int upOne = 1;
//		int upTwo = 1;
//		int temp = 0;
//		if(N == 0){
//			return temp;
//		}
//		for (int i = 1; i < N; i++) {
//			if (i > 1) {
//				temp = upOne + upTwo;
//				upOne = upTwo;
//				upTwo = temp;
//			}
//		}
//		return upTwo;


		//		if(N == 0){
//			return 0;
//		}
//		if(N == 1 || N == 2){
//			return 1;
//		}
//		return fib(N-1) + fib(N-2);
	}

	public static int fibcall(int N, int[] cache){
		if(N ==0 || N == 1){
			return N;
		}
		if(cache[N] != 0){
			return cache[N];
		}
		int result = fibcall(N - 2, cache) + fibcall(N - 1, cache);
		if(cache[N]==0){
			cache[N] = result;
		}
		return result;
	}


}
