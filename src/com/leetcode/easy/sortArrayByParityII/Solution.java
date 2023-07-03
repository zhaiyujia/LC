package com.leetcode.easy.sortArrayByParityII;

/**
 * @author zhaiyj
 * @date 2019/4/30 9:03
 * @instruction 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 */
public class Solution {

	public static void main(String[] args) {
		int[] A = new int[]{3, 4};
		sortArrayByParityII(A);
	}

	/**
	 * 输入：[4,2,5,7]
	 * 输出：[4,5,2,7]
	 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
	 *
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParityII(int[] A) {

		// 遍历A数组的偶数位，如果该位置是偶数就继续，否则与奇数位的偶数进行互换
		int j = 1;
		for (int i = 0; i < A.length; i+=2) {
			// 判断奇数
			if (A[i]%2==1){
				while(A[j] % 2 == 1){
					j += 2;
				}
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		return A;

		/**
		 * 定义一个新的数组
		 * 头尾指针换位置
		 */
//		int[] result = new int[A.length];
//		int x = A.length - 2;
//		int y = 1;
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] % 2 == 0) {
//				result[x] = A[i];
//				x = x - 2;
//			} else {
//				result[y] = A[i];
//				y = y + 2;
//			}
//		}
//		return result;

		/**
		 * 1.循环判断A[i]是否与i同是奇数或偶数
		 * 2.如果不是换位置(怎么换)
		 */
//		失败
//		int k = 0;
//		int z = 0;
//		int temp = 0;
//		int[] result = A.clone();
//		for (int i = 0; i < A.length; i++) {
//			// 偶数
//			if(A[i]%2==0){
//				temp = result[k];
//				result[k] = result[i];
//				result[i] = temp;
//				k += 2;
//			}else{
//				temp = result[z];
//				result[z] = result[i];
//				result[i] = temp;
//				z +=1;
//			}
//		}
//		return result;
		/**
		 * 1.先给数组排序
		 * 2.中间分隔，因为偶数数组
		 * 3.循环2个数组搞事情
		 */
//		int[] result = new int[A.length];
//		Arrays.sort(A);
//		int[] first = new int[A.length/2];
//		int[] second = new int[A.length/2];
//		int count = 0;
//		int fi = 0;
//		for (int i = 0; i < A.length; i++) {
//			if(A[i]%2!=0){
//				second[count] = A[i];
//				count++;
//			}else{
//				first[fi] = A[i];
//				fi++;
//			}
//		}
//
//		int x = 0;
//		for (int i = 0; i < first.length; i++) {
//			result[x] = first[i];
//			result[x+1] = second[i];
//			x += 2;
//		}
//		return result;
	}
}
