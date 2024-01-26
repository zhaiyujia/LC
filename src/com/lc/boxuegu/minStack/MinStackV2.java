package com.lc.boxuegu.minStack;

import java.util.Stack;

/**
 * @author zhai
 * @date 2024/1/26 6:28 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class MinStackV2 {


    private Node head;

    public MinStackV2() {

    }


    public void push(int val) {
        if(head == null){
            head = new Node(val, val);
        }else{
            int min = Math.min(head.min, val);
            Node next = head;
            head = new Node(val, min, next);
        }
    }

    public void pop() {
//        head = head.next;
        Node node = head;
        head = head.next;
        node.next = null;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
