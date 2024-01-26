package com.lc.boxuegu.minStack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author zhai
 * @date 2024/1/26 6:28 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> mStack;

    public MinStack() {
        this.stack = new Stack();
        this.mStack = new Stack();
    }


    public void push(int val) {
        stack.push(val);
        if (mStack.isEmpty() || val <= mStack.peek()) {
            mStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == mStack.peek()){
            mStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }


}
