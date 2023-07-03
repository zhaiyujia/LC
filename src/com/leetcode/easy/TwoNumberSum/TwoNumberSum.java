package com.leetcode.easy.TwoNumberSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 */
public class TwoNumberSum {

	/**
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,4};
		sum(nums, 6);
	}

	public static int[] sum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int index = 0;
			int oneNumber = nums[i];
			int diffValue = target - oneNumber;
			if (map.containsKey(diffValue) && map.get(diffValue)!= i) {
				index = map.get(diffValue);
				return new int[]{i, index};
			}
		}
		return null;
	}

}
