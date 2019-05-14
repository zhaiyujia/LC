package com.leetcode.repeatedNTimes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaiyj
 * @date 2019/4/3 9:01
 * @instruction
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 */
public class RepeatedNTimes {

	public static void main(String[] args) {
		int[] a = {2,1,2,5,3,2};
		int result = repeatedNTimes(a);
		System.out.println(result);
	}

	/**
	 * 输入：[1,2,3,3]
	 * 输出：3
	 *
	 * 输入：[2,1,2,5,3,2]
	 * 输出：2
	 * @param A
	 * @return
	 */
	public static int repeatedNTimes(int[] A) {
		int N=A.length/2;
		int count=1;
		for(int i=0;i<A.length-1;i++){
			for(int j=i+1;j<A.length;j++){
				if(A[i]==A[j]){
					count++;
					if(count==N){
						return A[i];
					}
				}
			}
		}
		return 0;
	}

}
