package com.leetcode.easy.majorityElement;

import java.util.Arrays;

/**
 * @author zhaiyj
 * @date 2019/6/19 8:54
 * @instruction
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 [n/2] 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int x = majorityElement(nums);
		System.out.println(x);
	}

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int x = nums[nums.length/2];
		return x;


//		int count = 1;
//		int current = nums[0];
//		for (int i =1; i < nums.length; i++) {
//			if(count==0){
//				current = nums[i];
//			}
//
//			if(current == nums[i]){
//				count++;
//			}else{
//				count--;
//			}
//		}
//		return current;




//		Map<Integer,Integer> map = new HashMap<>();
//
//		for (int i = 0; i < nums.length; i++) {
//			int x = nums[i];
//			if(map.containsKey(x)){
//				int c = map.get(x);
//				c++;
//				map.put(x,c);
//			}else{
//				map.put(x,1);
//			}
//		}
//
//		for(Integer key : map.keySet()){
//			int x = map.get(key);
//			if(x>count){
//				return key;
//			}
//		}
//		return 0;
	}

}
