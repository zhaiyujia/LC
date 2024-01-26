package com.lc.boxuegu.detectCycle;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhai
 * @date 2024/1/24 12:21 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        Set<ListNode> cache = new HashSet<>();
        while (head != null){
            if(cache.contains(head)){
                return head;
            }
            cache.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        if(head == head.next){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null || fast.next == null){
                return null;
            }
            if(slow == fast){
                break;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
