package com.lc.boxuegu.M_sortList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2025/5/22 20:38
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 5, 3, 4, 0};
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            ListNode node = new ListNode();
            node.val = num;
            head.next = node;
            head = head.next;
        }
        Solution solution = new Solution();
        solution.sortList1(cur.next);
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode head2 = middleNode(head);

        head = sortList(head);
        head2 = sortList(head2);

        return mergeTwoLists(head, head2);

    }


    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }


    public ListNode middleNode(ListNode head) {
        // 寻找中间节点
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }


    public ListNode sortList1(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode cur = head;
        List<ListNode> cache = new ArrayList<>();
        while (cur != null) {
            cache.add(cur);
            cur = cur.next;
        }


        cache.sort((o1, o2) -> o1.val - o2.val);


        ListNode node = new ListNode();
        head = node;
        for (ListNode listNode : cache) {
            node.next = listNode;
            listNode.next = null;
            node = node.next;
        }
        return head.next;
    }


    public static class ListNode {
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
