package com.leetcode.MyQueue;

import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/7/18 9:04
 * @description
 */
public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    public static void main(String[] args) {
        String str = "1.01";
        String[] str1 = str.split("\\.");
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }
//        MyQueue queue = new MyQueue();
//
//        queue.push(1);
//        queue.push(2);
//
//        int x = queue.peek();
//        x = queue.pop();
//        boolean flag = queue.empty();
    }



    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
//        stack1.push(x);
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
       return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
//        if(stack2.isEmpty()){
//            int size = stack1.size();
//            for (int i = 0; i < size; i++) {
//                int x = stack1.pop();
//                stack2.push(x);
//            }
//        }
//        return stack2.peek();
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
//        if(stack2.isEmpty()){
//            return true;
//        }
//        return false;
        return s1.isEmpty() && s2.isEmpty();
    }


}
