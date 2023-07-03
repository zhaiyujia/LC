package com.leetcode.easy.commonChars;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/5/8 8:45
 * @instruction 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 */
public class Solution {

	public static void main(String[] args) {
		String[] A = new String[]{"cool","lock","cook"};
//		commonChars(A);
		test(A);
	}

	public static List<String> test(String[] A){
		List<String> result = new ArrayList<>();
		int[] p = new int[26];
		for (int i = 0; i < 26; i++) {
			p[i] = 0;
		}
		for(char c : A[0].toCharArray()){
			p[c-'a']++;
		}

//		for (int i = 0; i < A[0].length(); i++) {
//			p[A[0].charAt(i) - 'a'] ++;
//		}

		for (int i = 1; i < A.length; i++) {
			int[] temp = new int[26];
			for (int j=0;j<26;j++){
				temp[j] = 0;
			}
			for(char c : A[i].toCharArray()){
				temp[c - 'a']++;
			}
//			for (int j = 0; j < A[i].length(); j++) {
//				temp[A[i].charAt(j) - 'a'] ++;
//			}
			for (int j = 0; j < 26; j++) {
				p[j] = Math.min(p[j], temp[j]);
//				if(p[j] > temp[j]){
//					p[j] = temp[j];
//				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if(p[i] > 0){
				for (int j = 0; j < p[i]; j++) {
					result.add(((char)('a'+i) + ""));
				}
			}
		}
		return result;
	}


	/**
	 * 输入：["bella","label","roller"]
	 * 输出：["e","l","l"]
	 * <p>
	 * 输入：["cool","lock","cook"]
	 * 输出：["c","o"]
	 *
	 * @param A
	 * @return
	 */
	public static List<String> commonChars(String[] A) {
		List<String> result = new ArrayList<>();
		String str = A[0];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			if (map.containsKey(s)) {
				int x = map.get(s);
				map.put(s, x += 1);
			} else {
				map.put(s, 1);
			}
		}

		Map<String, Integer> mapx = new HashMap<>();
		Map<String, Integer> mapy = new HashMap<>(map);
		for (int i = 1; i < A.length; i++) {
			String ss = A[i];
			for (int j = 0; j < ss.length(); j++) {
				String s = String.valueOf(ss.charAt(j));
				if (mapx.containsKey(s)) {
					int x = mapx.get(s);
					mapx.put(s, x+=1);
				} else {
					mapx.put(s, 1);
				}
			}

			map.forEach((k,v)->{
				if(mapx.containsKey(k)){
					int count = mapx.get(k);
					if(v > count){
						mapy.put(k,count);
					}
				}else{
					mapy.remove(k);
				}
			});
			mapx.clear();
			map = new HashMap<>(mapy);
		}
		mapy.forEach((k,v)->{
			if(v>1){
				for (int i = 0; i < v; i++) {
					result.add(k);
				}
			}else {
				result.add(k);
			}
		});
		return result;
	}

}
