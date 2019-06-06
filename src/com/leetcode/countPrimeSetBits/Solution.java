package com.leetcode.countPrimeSetBits;

/**
 * @author zhaiyj
 * @date 2019/6/4 9:00
 * @instruction 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 */
public class Solution {


	public static void main(String[] args) {
		int l = 10;
		int r = 15;
		int x = countPrimeSetBits(l, r);
		System.out.println(x);
	}


	public static int countPrimeSetBits(int L, int R) {

		int primeBit = 0x50451456;

		int ans = 0;
		for (; L <= R; L++) {
			int bits = Integer.bitCount(L)-1;
			ans += ((primeBit>>bits) & 1);
		}

		return ans;

//		int res = 0;
//		for (int i = L; i <= R; i++) {
//			int size  = Integer.bitCount(i);
//			boolean flag = true;
//			if(size==2){
//				res++;
//			}
//			if(size>=3){
//				for (int j=2;j<size;j++){
//					if(size%j==0){
//						flag = false;
//					}
//				}
//				if(flag==true){
//					res++;
//				}
//			}
//
//		}
//		return res;
	}

}

