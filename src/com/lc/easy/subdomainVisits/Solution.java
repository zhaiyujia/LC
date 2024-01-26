package com.lc.easy.subdomainVisits;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/5/28 9:04
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		String[] cpdomains = {"9001 discuss.leetcode.com"};
		subdomainVisits(cpdomains);
	}

	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String s: cpdomains) {
			String[] sSp = s.split(" ");
			int times = Integer.parseInt(sSp[0]);
			String domain = sSp[1];
			updateMap(domain, times, map);
			String newDomain = dotSplit(domain);
			while (newDomain != domain) {
				updateMap(newDomain, times, map);
				domain = newDomain;
				newDomain = dotSplit(domain);
			}
		}
		LinkedList<String> list = new LinkedList<>();
		for (String key: map.keySet()
				) {
			list.add(map.get(key)+ " " + key);
		}
		return list;
	}

	private static void updateMap(String domain, int times, HashMap<String, Integer> map) {
		if (!map.keySet().contains(domain)) {
			map.put(domain, times);
		}
		else {
			map.replace(domain, map.get(domain) + times);
		}
	}

	private static String dotSplit(String s) {
		int firstDotIndex = findFirstDot(s);
		return s.substring(firstDotIndex+1);
	}

	private static int findFirstDot(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.'){
				return i;
			}
		}
		return -1;
	}



/*	*//**
	 * 输入:
	 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
	 * 输出:
	 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
	 * 说明:
	 * 按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
	 * 而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
	 *
	 * @param cpdomains
	 * @return
	 *//*
	public static List<String> subdomainVisits(String[] cpdomains) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> maps = new HashMap<>();
		for (int i = 0; i < cpdomains.length; i++) {
			String[] str = cpdomains[i].split(" ");
			int x = Integer.valueOf(str[0]);

			if (maps.containsKey(str[1])) {
				int count = maps.get(str[1]);
				count = count + x;
				maps.put(str[1], count);
			} else {
				maps.put(str[1], x);
			}
			int k = 0;
			int index = str[1].indexOf(".", k);
			while (index != -1) {
				k = index + 1;
				index = str[1].indexOf(".", index+1);
				String newStr = "";
				if (index == -1) {
					newStr = str[1].substring(k);
				}else{
					newStr = str[1].substring(k);
				}


				if (maps.containsKey(newStr)) {
					int count = maps.get(newStr);
					count = count + x;
					maps.put(newStr, count);
				} else {
					maps.put(newStr, x);
				}
			}
		}
		maps.forEach((k, v) -> {
			result.add(v + " " + k);
		});


		return result;
	}*/

}
