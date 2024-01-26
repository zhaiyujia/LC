package com.lc.easy.smallestSubsequence;

import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/11/14 9:15 上午
 */
public class Solution {

    public static void main(String[] args) {
        String text = "ecbacba";
        smallestSubsequence(text);
    }

    public static String smallestSubsequence(String text) {
        int length = text.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Character c = text.charAt(i);
            if(stack.contains(c)){
                continue;
            }
            while (!stack.isEmpty()
                    && c<stack.peek()
                    && text.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

}
