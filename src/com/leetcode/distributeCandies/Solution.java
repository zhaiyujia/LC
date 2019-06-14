package com.leetcode.distributeCandies;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/6/12 8:50
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		int[] candies = new int[]{1,1,2,2,3,3,4,4};
		int res = distributeCandies(candies);
		System.out.println(res);
	}

	public static int distributeCandies(int[] candies) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : candies) {
			min = Math.min(min,i);
			max = Math.max(max,i);
		}

		boolean[] index = new boolean[max-min+1];
		int ans = 0;
		for (int i = 0; i < candies.length; i++) {
			if(!index[candies[i]-min]){
				ans++;
				if(ans>=candies.length/2){
					return ans;
				}
				index[candies[i]-min] = true;
			}
		}

		return ans;

//		Set<Integer> set = new HashSet<>();
//		int ans = 0;
//		for (int candy : candies) {
//			if (set.size() < candies.length / 2 && set.add(candy)) {
//				ans++;
//			}
//		}
//		return ans;
	}

}
