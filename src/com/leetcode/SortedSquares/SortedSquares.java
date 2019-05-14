package com.leetcode.SortedSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/3/20 9:22
 * @instruction
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SortedSquares {

	public static void main(String[] args) {

		int[] a = new int[]{-4, -1, 0, 3, 10};
		sortedSquares(a);
	}

	/**
	 * 输入：[-4,-1,0,3,10]
	 * 输出：[0,1,9,16,100]
	 *
	 * 输入：[-7,-3,2,3,11]
	 * 输出：[4,9,9,49,121]
	 * @param A
	 * @return
	 */
	public static int[] sortedSquares(int[] A) {

		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int x = A[i] * A[i];
			result[i] = x;
		}
		Arrays.sort(result);
		int temp;
//		for (int i = 0; i < result.length; i++) {
//			for (int j = 0; j < result.length - i - 1; j++) {
//				if (result[j] > result[j + 1]) {
//					temp = result[j];
//					result[j] = result[j + 1];
//					result[j + 1] = temp;
//				}
//			}
//
//		}
		return result;
	}



}
