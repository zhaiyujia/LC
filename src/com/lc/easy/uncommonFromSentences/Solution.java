package com.lc.easy.uncommonFromSentences;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/7/4 8:54
 * @instruction
 */
public class Solution {


	public static void main(String[] args) {
		String a = "this apple is sweet";
		String b = "this apple is sour";
		uncommonFromSentences(a, b);
	}


	public static String[] uncommonFromSentences(String A, String B) {
//		String c = A + " " + B;
//		String[] ss = c.split(" ");
//		Map<String,Integer> maps = new HashMap<>();
//		for (int i = 0; i < ss.length; i++) {
//			String key = ss[i];
//			if(maps.containsKey(key)){
//				int count = maps.get(key);
//				count++;
//				maps.put(key,count);
//			}else{
//				maps.put(key,1);
//			}
//		}
//
//		List<String> list = new ArrayList<>();
//		int x = 0;
//		for (String s : maps.keySet()) {
//			int count = maps.get(s);
//			if(count==1){
//				list.add(s);
//				x++;
//			}
//		}
//		String[] res = new String[x];
//		return list.toArray(res);

		Map<String,Integer> map=new HashMap();
		if(A.length()>0){
			int index=A.indexOf(' ');
			String tmpStr=A;
			while(index!=-1){
				tmpStr=A.substring(0,index);
				if(map.containsKey(tmpStr)){
					map.put(tmpStr,map.get(tmpStr)+1);
				}else{
					map.put(tmpStr,1);
				}
				A=A.substring(index+1);
				index=A.indexOf(' ');
			}
			if(map.containsKey(A)){
				map.put(A,map.get(A)+1);
			}else{
				map.put(A,1);
			}

		}

		if(B.length()>0){
			int index=B.indexOf(' ');
			String tmpStr=B;
			while(index!=-1){
				tmpStr=B.substring(0,index);
				if(map.containsKey(tmpStr)){
					map.put(tmpStr,map.get(tmpStr)+1);
				}else{
					map.put(tmpStr,1);
				}
				B=B.substring(index+1);
				index=B.indexOf(' ');
			}
			if(map.containsKey(B)){
				map.put(B,map.get(B)+1);
			}else{
				map.put(B,1);
			}

		}

		List<String> list=new ArrayList();
		for(Map.Entry<String,Integer> entry:map.entrySet()){
			if(entry.getValue()<2){
				list.add(entry.getKey());
			}
		}
		return list.toArray(new String[list.size()]);
	}


}
