package com.lc.easy.DiStringMatch;

/**
 * @author zhaiyj
 * @date 2019/3/21 9:02
 * @instruction
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 */
public class DiStringMatch {

	/**
	 * 输出："IDID"
	 * 输出：[0,4,1,3,2]
	 *
	 * 输出："III"
	 * 输出：[0,1,2,3]
	 *
	 * 输出："DDI"
	 * 输出：[3,2,0,1]
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "IDID";
		diStringMatch(str);

	}

	public static int[] diStringMatch(String S) {
		int N = S.length();
		int i = 0, j = N, k;
		int[] A = new int[N + 1];
		for (k = 0; k < N; k++) {
			if (S.charAt(k) == 'I') {
				A[k] = i++;
			} else {
				A[k] = j--;
			}
		}
		A[k] = j;
		return A;
	}
}
