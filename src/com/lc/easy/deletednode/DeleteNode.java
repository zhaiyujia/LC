package com.lc.easy.deletednode;

/**
 * @author zhaiyj
 * @date 2019/3/22 9:06
 * @instruction 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 */
public class DeleteNode {

    /**
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，
     * 那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param args
     */
    public static void main(String[] args) {
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node1 = new ListNode(1);
		ListNode node9 = new ListNode(9);
		node4.next = node5;
		node5.next = node1;
		node1.next = node9;
		ListNode node = deleteNode(node4, 1);
		System.out.println(node);
	}


    public static ListNode deleteNode(ListNode node, Integer value) {
		ListNode preNode = null;
		ListNode tempNode = null;
		ListNode currentNode = node;
		// 第一
        if(node.val == value){
        	return node.next;
		}
        return node;
    }

}
