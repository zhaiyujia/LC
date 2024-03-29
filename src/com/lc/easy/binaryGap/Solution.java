package com.lc.easy.binaryGap;

/**
 * @author zhaiyj
 * @date 2019/6/24 9:07
 * @instruction
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * 如果没有两个连续的 1，返回 0 。
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(22));

//		int n = 22;
//		int res = binaryGap(n);
//		System.out.println(res);
	}

	public static int binaryGap(int N) {

		if(N<2){
			return 0;
		}

		int right = 0;
		int left = 0;
		int idx = 0;
		int res = 0;

		while (N>0){
			idx++;
			if((N&1)==1){
				int temp = left;
				left = idx;
				if(right==0){
					right = left;
				}else{
					right = temp;
				}
				res = Math.max(res,left-right);
			}
			N = N >> 1;
		}
		return res;

//		String str = Integer.toBinaryString(N);
//		// 不包含1的，直接返回0
//		if(str.indexOf("1")==-1){
//			return 0;
//		}
//		if(str.indexOf("1") == str.lastIndexOf("1")){
//			return 0;
//		}
//		List<Integer> sortList = new ArrayList<>();
//		int index = str.indexOf("1");
//		char c = str.charAt(index);
//		int count = 0;
//		int size = str.length();
//		for (int i = index+1; i < size; i++) {
//			char x = str.charAt(i);
//			if(x == c){
//				int distance = i-index;
//				if(distance>count){
//					count = distance;
//				}
//				index = str.indexOf("1",i);
//				sortList.add(count);
//				count = 0;
//			}
//		}
//		Collections.sort(sortList);
//		return sortList.get(sortList.size()-1);
	}

}
