package com.lc.boxuegu.reverseList;

/**
 * @author zhai
 * @date 2024/1/19 5:28 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class ListNode {

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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            curr.next = node;
            curr = node;
        }

    }
}
