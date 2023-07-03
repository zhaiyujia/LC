package com.leetcode.easy.peakIndexInMountainArray;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2019/4/9 9:14
 * @instruction
 * 我们把符合下列属性的数组 A 称作山脉：
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 */
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		int[] A = new int[]{0,2,1,0};
		int result = peakIndexInMountainArray(A);
		System.out.println(result);
	}


	/**
	 * 示例 1：
	 * 输入：[0,1,0]
	 * 输出：1
	 *
	 * 输入：[0,2,1,0]
	 * 输出：1
	 *
	 * @param A
	 * @return
	 */
	public static int peakIndexInMountainArray(int[] A) {

		int result = Arrays.stream(A).max().getAsInt();
		for (int i = 0; i < A.length; i++) {
			if(A[i] == result){
				return i;
			}
		}

		return 0;
	}

}
