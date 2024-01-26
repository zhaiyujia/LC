package com.lc.easy.smallestRangeI;

/**
 * @author zhaiyj
 * @date 2019/5/7 9:04
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		int[] A = new int[]{0,10};
		int result = smallestRangeI(A,2);
		System.out.println(result);
	}

	public static int smallestRangeI(int[] A, int K) {

		int min = 10001;
		int max = -1;
		for(int i=0; i<A.length; ++i){
			if (min > A[i]) {
				min = A[i];
			}
			if (max < A[i]) {
				max = A[i];
			}
		}
		return Math.max(0,max-min-2*K);

//		Arrays.sort(A);
//		int max = A[A.length-1];
//		int min = A[0];
//		return Math.max(0,max-min-2*K);

//		Arrays.sort(A);
//		int max = A[A.length-1];
//		int min = A[0];
//		int result = (max-min) -(2*K);
//		return result>0?result:0;

//		int max = A[0];
//		int min = A[0];
//
//		for (int i = 0; i < A.length; i++) {
//			if(max < A[i]){
//				max = A[i];
//			}
//			if(min > A[i]){
//				min = A[i];
//			}
//		}
//		int result = (max - min) - (2*K);
//
//		return result>0?result:0;
	}
}
