package com.leetcode.easy.romanToInt;

/**
 * @author zhaiyj
 * @date 2019/7/24 9:01
 * @description
 */
public class Solution {

//    static Map<Character, Integer> maps = new HashMap<>();
//    static Map<String, Integer> mapss = new HashMap<>();
//    static {
//        maps.put('I',1);// 73
//        maps.put('V',5);// 86
//        maps.put('X',10);// 88
//        maps.put('L',50);// 76
//        maps.put('C',100);// 67
//        maps.put('D',500);// 68
//        maps.put('M',1000);// 77
//
//        mapss.put("IV",4);
//        mapss.put("IX",9);
//        mapss.put("XL",40);
//        mapss.put("XC",90);
//        mapss.put("CD",400);
//        mapss.put("CM",900);
//    }


    public static void main(String[] args) {

        String s = "MCMXCIV";
        romanToInt(s);

    }

    public static int romanToInt(String s) {

        int result = 0;
        if (null == s || "".equals(s.trim())) {
            return result;
        }

        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length;) {
            switch (chars[index]) {
                case 'I' :
                    if (index < chars.length - 1) {
                        if ('V' == chars[index + 1]) {
                            result = result + 4;
                            index += 2;
                        } else if ('X' == chars[index + 1]) {
                            result = result + 9;
                            index += 2;
                        } else {
                            result = result + 1;
                            index++;
                        }
                    } else {
                        result = result + 1;
                        index++;
                    }
                    break;
                case 'X':
                    if (index < chars.length - 1) {
                        if ('L' == chars[index + 1]) {
                            result = result + 40;
                            index += 2;
                        } else if ('C' == chars[index + 1]) {
                            result = result + 90;
                            index += 2;
                        } else {
                            result = result + 10;
                            index++;
                        }
                    } else {
                        result = result + 10;
                        index++;
                    }
                    break;
                case 'C':
                    if (index < chars.length - 1) {
                        if ('D' == chars[index + 1]) {
                            result = result + 400;
                            index += 2;
                        } else if ('M' == chars[index + 1]) {
                            result = result + 900;
                            index += 2;
                        } else {
                            result = result + 100;
                            index++;
                        }
                    } else {
                        result = result + 100;
                        index++;
                    }
                    break;
                case 'V':
                    result = result + 5;
                    index++;
                    break;
                case 'L':
                    result = result + 50;
                    index++;
                    break;
                case 'D':
                    result = result + 500;
                    index++;
                    break;
                case 'M':
                    result = result + 1000;
                    index++;
                    break;
            }
        }
        return result;

//        int sum = 0;
//        int size = s.length();
//        for (int i = 0; i < size; i++) {
//            char c = s.charAt(i);
//            Integer first = maps.get(c);
//            if(i<=size-2){
//                char b = s.charAt(i+1);
//                switch (c+b){
//                    case 159:
//                        sum+=4;
//                        i=i+1;
//                        break;
//                    case 161:
//                        sum +=9;
//                        i=i+1;
//                        break;
//                    case 164:
//                        sum+=40;
//                        i=i+1;
//                        break;
//                    case 155:
//                        sum+=90;
//                        i=i+1;
//                        break;
//                    case 135:
//                        sum += 400;
//                        i=i+1;
//                        break;
//                    case 144:
//                        sum += 900;
//                        i=i+1;
//                        break;
//                    default:
//                        sum += first;
//                        break;
//                }
//            }else{
//                sum += first;
//            }
//        }
//        return sum;
    }


}
