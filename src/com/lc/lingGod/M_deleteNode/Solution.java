package com.lc.lingGod.M_deleteNode;

/**
 * @author zhaiyj
 * @date 2025/5/20 21:33
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
