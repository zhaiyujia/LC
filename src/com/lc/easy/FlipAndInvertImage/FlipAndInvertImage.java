package com.lc.easy.FlipAndInvertImage;

/**
 * @author zhaiyj
 * @date 2019/3/22 9:24
 * @instruction
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class FlipAndInvertImage {

	public static void main(String[] args) {
		int[][] a=new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		flipAndInvertImage(a);
	}

	/**
	 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
	 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
	 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
	 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
	 * @param A
	 * @return
	 */

	public static int[][] flipAndInvertImage(int[][] A) {
		int len = A.length;
		int[][] resut = A;
		for (int i = 0; i < len; i++) {
			int[] top = A[i];
			int topLen = top.length;
			int[] tamp = new int[topLen];
			int count = topLen - 1;
			for(int j=0;j<topLen;j++){
				int x = top[j];
				if(x==1){
					x = 0;
				}else{
					x = 1;
				}
				tamp[count] = x;
				count--;
			}
			resut[i] = tamp;
		}
		return resut;
	}

}
