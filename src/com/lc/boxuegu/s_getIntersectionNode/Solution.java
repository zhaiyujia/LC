package com.lc.boxuegu.s_getIntersectionNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaiyj
 * @date 2025/4/24 21:22
 */
public class Solution {



    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q){
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> s1 = new HashSet<>();
        ListNode temp = headA;
        while (temp != null){
            s1.add(temp);
            temp = temp.next;
        }


        temp = headB;
        while (temp != null){
            if(s1.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }



      public  static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }


}
