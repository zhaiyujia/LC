package com.leetcode.reverseList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/5/31 8:59
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		ListNode node = reverseList(listNode1);
		System.out.println(node);

	}


	public static ListNode reverseList(ListNode head) {

		if(head==null || head.next==null){
			return head;
		}

		ListNode pNext = head.next;
		head.next = null;
		ListNode rec = reverseList(pNext);
		pNext.next = head;
		return rec;


//		if(head==null){
//			return head;
//		}
//		ListNode pReversedHead = null;
//		ListNode pPrev = null;
//		ListNode pNode = head;
//		while (pNode.next!=null){
//			ListNode pNext = pNode.next;
//			if(pNext!=null){
//				pReversedHead = pNode;
//			}
//			pNode.next = pPrev;
//			pPrev = pNode;
//			pNode = pNext;
//		}
//		pNode.next = pReversedHead;
//		return pNode;
	}

}
