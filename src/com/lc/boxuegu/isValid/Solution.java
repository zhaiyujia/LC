package com.lc.boxuegu.isValid;

import java.util.Stack;

/**
 * @author zhai
 * @date 2024/1/25 11:13 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }

        char[] cs = s.toCharArray();
        if(cs.length % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack();
        for(char c : cs){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }


}
