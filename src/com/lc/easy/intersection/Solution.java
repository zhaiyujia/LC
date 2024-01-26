package com.lc.easy.intersection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaiyj
 * @date 2019/5/24 8:57
 * @instruction
 * 嵌套循环 大内小外
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution {


	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,5};
		int[] nums2 = new int[]{9,4,9,8,4};
		intersection(nums1,nums2);
	}


	/**
	 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
	 * 输出: [2]
	 *
	 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 * 输出: [9,4]
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for(int n : nums1){
			set.add(n);
		}

		for(int n : nums2){
			if(set.contains(n)){
				res.add(n);
			}
		}

		int[] result = new int[res.size()];
		int index = 0 ;
		for(int n : res){
			result[index++] = n;
		}
		return result;




//		Arrays.sort(nums1);
//		Arrays.sort(nums2);
//		Set<Integer> result = new HashSet<>();
//		for (int i = 0; i < nums1.length; i++) {
//			int number = nums1[i];
//			for (int j = 0; j < nums2.length; j++) {
//				if (nums2[j]==number) {
//					result.add(number);
//					continue;
//				}
//			}
//		}
//		int[] res = new int[result.size()];
//		int index=0;
//		for (Integer n : result) {
//			res[index++] = n;
//		}
//
//		return res;



//		Set<Integer> result = new HashSet<>();
//		for (int i = 0; i < nums1.length; i++) {
//			int x = nums1[i];
//			for (int j = 0; j < nums2.length; j++) {
//				if(nums2[j] == x){
//					result.add(x);
//				}
//			}
//		}
//		Iterator<Integer> it = result.iterator();
//		int[] rs = new int[result.size()];
//		int y=0;
//		while (it.hasNext()){
//			rs[y] = it.next();
//			y++;
//		}
//
//		return rs;
	}


}
