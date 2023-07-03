package com.leetcode.easy.selfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/4/10 9:05
 * @instruction
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 */
public class SelfDividingNumbers {

	public static void main(String[] args) {
		selfDividingNumbers(111,111);
	}

	/**
	 * 输入：上边界left = 1, 下边界right = 22
	 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
	 * @param left
	 * @param right
	 * @return
	 */
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		int temp = 0;
		int rem = 0;
		boolean isAdd = true;
		for (int i = left; i <= right; i++) {
			temp = i;
			isAdd = true;
			while (temp != 0){
				rem = temp % 10;
				if(rem == 0 || i % rem != 0){
					isAdd = false;
					break;
				}
				temp = temp / 10;
			}
			if(isAdd){
				result.add(i);
			}
		}
		return result;
	}

}
