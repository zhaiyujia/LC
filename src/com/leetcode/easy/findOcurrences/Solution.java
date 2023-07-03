package com.leetcode.easy.findOcurrences;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/7/16 8:54
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        findOcurrences(text, first, second);
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> set = new ArrayList<>();
        String [] str = text.split(" ");
        for (int i = 0; i < str.length; i++) {
            if(i+1>str.length){
                break;
            }
            String word = str[i];

            if(i<str.length-2){
                if(word.equals(first) && str[i+1].equals(second)){
                    set.add(str[i+2]);
                }
            }else{
                break;
            }
        }
//        String[] reuslt = new String[set.size()];
//        for (int i = 0; i < set.size(); i++) {
//            reuslt[i] = set.get(i);
//        }
        return set.toArray(new String[set.size()]);
    }
}
