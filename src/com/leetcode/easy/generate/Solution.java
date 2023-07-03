package com.leetcode.easy.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/5/30 9:05
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		int numRows = 5;
		generate(numRows);
	}


	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<>();
		int item = 1;
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			if(i==0){
				list.add(item);
			}else if(i==1){
				list.add(item);
				list.add(item);
			}else{
				list.add(item);
				List<Integer> upList = lists.get(i-1);
				for (int j = 1; j < upList.size(); j++) {
					list.add(upList.get(j)+upList.get(j-1));
				}
				list.add(item);
			}
			lists.add(list);
		}
		return lists;
	}


}
