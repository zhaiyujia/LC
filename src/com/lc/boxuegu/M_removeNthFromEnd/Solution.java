package com.lc.boxuegu.M_removeNthFromEnd;

import java.util.List;

/**
 * @author zhaiyj
 * @date 2025/5/20 21:12
 */
public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
         * 查找到第N个节点
         * 需要知道前一个节点和后一个节点
         * preNode cur(n) stuNode
         */

        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = dummy;
        while (n-- >0){
            right = right.next;
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
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
