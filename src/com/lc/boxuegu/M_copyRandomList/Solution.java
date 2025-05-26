package com.lc.boxuegu.M_copyRandomList;

/**
 * @author zhaiyj
 * @date 2025/5/26 21:06
 */
public class Solution {


    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        for(Node cur = head; cur != null; cur = cur.next.next){
            cur.next = new Node(cur.val, cur.next);
        }

        for(Node cur = head; cur != null; cur = cur.next.next){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
        }

        Node newHead = head.next;
        Node cur = head;
        for(; cur.next.next != null; cur = cur.next){
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = cur.next.next;
        }
        cur.next = null;
        return newHead;

    }


    public  static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {

        }
    }


}
