package com.lc.boxuegu.minStack;

import java.util.Stack;

/**
 * @author zhai
 * @date 2024/1/26 6:28 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class MinStackV1 {

    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStackV1() {
        this.stack = new Stack();
    }


    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int top = stack.pop();
        if(top == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }


}
