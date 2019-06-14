package com.leetcode.singleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaiyj
 * @date 2019/6/6 8:50
 * @instruction
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 *  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class singleNumber {

	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,1,2};
		int x = singleNumber(nums);
		System.out.println(x);
	}

	/**
	 * 输入: [2,2,1]
	 * 输出: 1
	 *
	 * 输入: [4,1,2,1,2]
	 * 输出: 4
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {

		int ans = nums[0];
		if(nums.length>1){
			for (int i = 1; i < nums.length; i++) {
				ans = ans ^ nums[i];
			}
		}
		return ans;

//		final int[] re = {0};
//		if(nums.length==1){
//			return nums[0];
//		}
//		Map<Integer,Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			int count = 1;
//			if(map.containsKey(nums[i])){
//				count = map.get(nums[i]);
//				count++;
//				map.put(nums[i],count);
//			}else{
//				map.put(nums[i],count);
//			}
//		}
//		map.forEach((k,v)->{
//			if(v==1){
//				re[0] = k;
//			}
//		});
//		return re[0];


//		if(nums.length==1){
//			return nums[0];
//		}
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i++) {
//			if(i==0){
//				if(nums[i] !=nums[i+1]){
//					return nums[0];
//				}
//			}
//
//			if(i>1 && i<nums.length-1){
//				// 表示偶数位
//				if(i%2==0){
//					if((nums[i] != nums[i-1]) && (nums[i] != nums[i+1])){
//						return nums[i];
//					}
//				}
//			}
//
//			if(i==nums.length-1){
//				if(nums[i]!=nums[i-1]){
//					return nums[i];
//				}
//			}
//		}
//		return 0;
	}


}
