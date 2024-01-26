package com.lc.easy.MyStack;

/**
 * @author zhaiyj
 * @date 2019/11/20 9:21 上午
 */
public class Solution {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(10);
        myStack.push(11);
        myStack.push(12);

        int x = myStack.pop();
        int y = myStack.top();
        boolean param_4 = myStack.empty();
        System.out.println("A");
    }

}
