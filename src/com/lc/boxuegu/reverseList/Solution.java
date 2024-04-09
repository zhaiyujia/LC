package com.lc.boxuegu.reverseList;

import java.util.Stack;

/**
 * @author zhai
 * @date 2024/1/19 5:28 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //1,2,3,4,5
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        s.reverseList2_1(n1);
    }


    public ListNode reverseList1_1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList1_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1_2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2_1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public ListNode reverseList2_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2_2(head);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList2_3(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode curr = stack.pop();
        head = curr;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            curr.next = pop;
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }


}
