package com.leetcode.boxuegu.addTwoNumbers;

/**
 * @author zhai
 * @date 2024/1/24 12:42 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        int carry = 0;
        ListNode l3 = new ListNode(-1);
        ListNode temp = l3;
        while (l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int c = (a + b + carry ) % 10;
            carry = (a + b + carry) / 10;

            l3.next = new ListNode(c);
            l3 = l3.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carry > 0){
            l3.next = new ListNode(carry);
        }
        return  temp.next;
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
