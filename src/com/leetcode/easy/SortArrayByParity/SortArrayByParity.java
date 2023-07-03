package com.leetcode.easy.SortArrayByParity;

/**
 * @author zhaiyj
 * @date 2019/3/26 9:11
 * @instruction
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 */
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] x = {3,1,2,4};
		sortArrayByParity(x);
	}

	/**
	 * 输入：[3,1,2,4]
	 * 输出：[2,4,3,1]
	 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParity(int[] A) {
		int[] result = new int[A.length];
		int count = A.length - 1;
		int down = 0;
		for (int i=0;i<A.length;i++){
			if(A[i]%2==0){
				result[down] = A[i];
				down++;
			}else{
				result[count] = A[i];
				count--;
			}
		}
		return A;
	}

}
