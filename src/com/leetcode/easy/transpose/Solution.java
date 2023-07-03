package com.leetcode.easy.transpose;

/**
 * @author zhaiyj
 * @date 2019/5/10 9:05
 * @instruction
 *
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class Solution {
	public static void main(String[] args) {
		int[][] A = new int[][]{{1,2,3},{4,5,6}};
		transpose(A);
	}

	/**
	 * 输入：[{1,2,3},{4,5,6},{7,8,9}]
	 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
	 *
	 * 输入：[{1,2,3},{4,5,6}]
	 * 输出：[[1,4],[2,5],[3,6]]
	 * @param A
	 * @return
	 */

	public static int[][] transpose(int[][] A) {

		int[][] result = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				result[j][i] = A[i][j];
			}
		}
		return result;



//		int[][] result = new int[A[0].length][A.length];
//		for (int i = 0; i < A.length; i++) {
//			for (int j = 0; j < A[0].length; j++) {
//				result[j][i] = A[i][j];
//			}
//		}
//		return result;

//		int x = 0;
//		int y = 0;
//		int[][] result = new int[A[0].length][A.length];
//		for (int i = 0; i < A.length; i++) {
//			for (int j = 0; j < A[0].length; j++) {
//				result[x][y] = A[i][j];
//				x++;
//			}
//			x = 0;
//			y += 1;
//		}
//		return result;
	}
}
