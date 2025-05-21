package com.lc.boxuegu.M_swapPairs;

import java.util.List;

/**
 * @author zhaiyj
 * @date 2025/5/21 20:50
 */
public class Solution {

    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1!= null && node1.next!= null){
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node3;
            node2.next = node1;
            node1.next = node3;

            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = node2.next;

        node1.next = swapPairs(node3); // 1 指向递归返回的链表头
        node2.next = node1; // 2 指向 1

        return node2; // 返回交换后的链表头节点
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
