package com.leetcode.easy.removeDuplicates;

import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/11/27 8:48 上午
 */
public class Solution {

    public static void main(String[] args) {
        String s = "aabbaca";
        removeDuplicates(s);
    }

    public static String removeDuplicates(String S) {
//        int top = 0;
//        char[] chars = S.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(top ==0 || chars[i] != chars[top-1]){
//                chars[top] = chars[i];
//                top++;
//            }else{
//                top--;
//            }
//        }
//        return new String(chars,0,top);

//        String result = "";
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < S.length(); i++) {
//            if (!stack.isEmpty()) {
//                Character peek = stack.peek();
//                if (peek == S.charAt(i)) {
//                    stack.pop();
//                } else {
//                    stack.push(S.charAt(i));
//                }
//            } else {
//                stack.push(S.charAt(i));
//            }
//        }
//        for (Character character : stack) {
//            result += character;
//        }
//        return result;


//        String result = "";
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if(result.equals("")){
//                result += c;
//            }else{
//                char x = result.charAt(result.length() - 1);
//                if(x == c){
//                    result = result.substring(0,result.length() -1);
//                }else{
//                    result += c;
//                }
//            }
//        }
//        return result;
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || chars[i] != stack.peek()) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }

}
