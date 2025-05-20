package com.lc.lingGod.S_deleteDuplicates;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaiyj
 * @date 2025/5/20 21:36
 */
public class Solution {


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}
