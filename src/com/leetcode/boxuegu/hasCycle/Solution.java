package com.leetcode.boxuegu.hasCycle;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhai
 * @date 2024/1/20 10:11 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //1,2,3,4,5
        int[] nums = new int[]{1,2,3,4,5};
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        solution.hasCycleV1(n1);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == null || fast.next == null){
                return false;
            }

            if(fast == slow){
                break;
            }
        }

        return true;
    }

    public boolean hasCycleV1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null){
            if(!seen.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleV2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        if (head == head.next) {
            return true;
        }

        ListNode nextNode = head.next;
        head.next = nextNode;
        return hasCycleV2(nextNode);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
