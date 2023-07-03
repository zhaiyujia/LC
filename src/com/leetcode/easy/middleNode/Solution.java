package com.leetcode.easy.middleNode;

/**
 * @author zhaiyj
 * @date 2019/6/13 8:55
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
		ListNode node6 = new ListNode(6);


		ListNode node5 = new ListNode(5);
//		node5.next = node6;

		ListNode node4 = new ListNode(4);
		node4.next = node5;


		ListNode node3 = new ListNode(3);
		node3.next = node4;


		ListNode node2 = new ListNode(2);
		node2.next = node3;

		ListNode node1 = new ListNode(1);
		node1.next = node2;

		middleNode(node1);
	}

	public static ListNode middleNode(ListNode head) {


		ListNode fast = head;
		ListNode slow = head;

		while (fast != null  && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;



//		if(head.next==null){
//			return head;
//		}
//
//		Stack<ListNode> stack = new Stack<>();
//		stack.add(head);
//		int x = 0;
//		while (!stack.isEmpty()){
//			ListNode node = stack.pop();
//			if(node.next!=null){
//				stack.add(node.next);
//				x++;
//			}
//		}
//		System.out.println(x);
//		ListNode result = null;
//		for (int i = 0; i < x; i++) {
//			if(i == x/2 && x%2==0){
//				break;
//			}
//
//			if(x%2!=0 && i == x/2+1){
//				break;
//			}
//
//			result = head.next;
//			head = result;
//		}
//
//		return result;
	}


}
