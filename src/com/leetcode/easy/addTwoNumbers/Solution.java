package com.leetcode.easy.addTwoNumbers;

import java.util.LinkedList;

/**
 * @author zhaiyj
 * @date 2019/5/6 8:57
 * @instruction 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution {

    public static void main(String[] args) {

        ListNode node13 = new ListNode(3, null);
        ListNode node12 = new ListNode(4, node13);
        ListNode node1 = new ListNode(2, node12);

        ListNode node23 = new ListNode(4, null);
        ListNode node22 = new ListNode(6, node23);
        ListNode node2 = new ListNode(5, node22);

        addTwoNumbers(node1, node2);


    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
        }
        return dummyHead.next;


//		ListNode res = null;
//		int one = sum(l1);
//		int two = sum(l2);
//		int sum = two + one;
//		String[] result = String.valueOf(sum).split("");
//		for (int i = result.length-1; i >=0 ; i--) {
//			if(i!=result.length-1){
//				res = new ListNode(Integer.valueOf(result[i]),res);
//			}else{
//				res = new ListNode(Integer.valueOf(result[i]),null);
//			}
//		}
//		return res;
    }

    public static int sum(ListNode listNode) {
        String result = "";
        LinkedList<ListNode> p = new LinkedList<>();
        p.add(listNode);
        while (!p.isEmpty()) {
            ListNode node = p.pop();
            int val = node.val;
            if (node.next != null) {
                p.add(node.next);
            }
            result = val + result;
        }
        return Integer.valueOf(result);
    }

}
