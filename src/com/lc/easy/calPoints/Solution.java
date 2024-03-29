package com.lc.easy.calPoints;

/**
 * @author zhaiyj
 * @date 2019/5/29 9:14
 * @instruction 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 */
public class Solution {

	public static void main(String[] args) {
		String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
		calPoints(ops);
	}

	/**
	 * 输入: ["5","-2","4","C","D","9","+","+"]
	 * 输出: 27
	 * 解释:
	 * 第1轮：你可以得到5分。总和是：5。
	 * 第2轮：你可以得到-2分。总数是：3。
	 * 第3轮：你可以得到4分。总和是：7。
	 * 操作1：第3轮的数据无效。总数是：3。
	 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
	 * 第5轮：你可以得到9分。总数是：8。
	 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
	 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
	 *
	 * @param ops
	 * @return
	 */
	public static int calPoints(String[] ops) {

		int[] arr = new int[ops.length];
		int i = 0;
		for (String s : ops) {
			switch (s) {
				case "+":
					arr[i] = arr[i-1] + arr[i-2];
					i++;
					break;
				case "D":
					arr[i] = 2 * arr[i-1];
					i++;
					break;
				case "C":
					arr[i-1] = 0;
					i--;
					break;
				default:
					arr[i]=Integer.valueOf(s);
					i++;
			}
		}

		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[i];
		}
		return sum;
	}

}
