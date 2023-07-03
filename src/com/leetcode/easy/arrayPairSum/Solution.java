package com.leetcode.easy.arrayPairSum;

/**
 * @author zhaiyj
 * @date 2019/4/28 9:04
 * @instruction
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		int result = arrayPairSum(nums);
		System.out.println(result);
	}

	/**
	 * 输入: [1,4,3,2]
	 * 输出: 4
	 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
	 * @param nums
	 * @return
	 */
	public static int arrayPairSum(int[] nums) {

		int[] exist = new int[20];
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			exist[nums[i] + 10]++;
		}
		int sum = 0;
		boolean odd = true;
		for(int i=0;i<20;i++){
			while (exist[i]>0){
				if(odd){
					sum +=i-10;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;

//		int sum = 0;
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i=i+2) {
//			sum = sum + nums[i];
//		}
//		return sum;
//		int sum = 0;
//		int i=0;
//		Arrays.sort(nums);
//		while (i<nums.length){
//			sum = sum + nums[i];
//			i = i+2;
//		}
//		return sum;


//		long begin = System.currentTimeMillis();
//		int sum = 0;
//		Arrays.sort(nums);
//		long first = System.currentTimeMillis();
//		System.out.println(first-begin);
//		for (int i = 1; i <= nums.length; i++) {
//			if(i%2==0){
//				int x = Math.min(nums[i-2],nums[i-1]);
//				sum = sum + x;
//			}
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - first);
//		return sum;
	}


}
