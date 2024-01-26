package com.lc.easy.isToeplitzMatrix;

/**
 * @author zhaiyj
 * @date 2019/6/18 8:59
 * @instruction
 */
public class Solution {


	public static void main(String[] args) {

		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 1, 2, 3},
				{9, 5, 1, 2}
		};
		boolean res = isToeplitzMatrix(matrix);
		System.out.println(res);

	}

	public static boolean isToeplitzMatrix(int[][] matrix) {

		boolean flag = true;
		int size = matrix[0].length-1;
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}


}
