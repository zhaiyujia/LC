package com.leetcode.mid.addTwoNumbers;

/**
 * @author zhai
 * @date 2023/7/3 4:10 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

    }

    public static void test4() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);

    }

    public static void test3() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode listNode = addTwoNumbers(l1, l2);

    }


    public static void test2() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);

    }

    public static void test1() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);

    }


    private static ListNode reverse(ListNode node) {
        ListNode current = null, prev = null;
        while (node != null) {
            current = node;
            node = node.next;
            current.next = prev;
            prev = current;
        }
        return prev;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);

        return addTwoNumbers1(t1, t2);
    }


    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        if (l1.val == 0 && l2.val == 0) {
            return new ListNode(0);
        }

        /**
         * 7 2 4 3
         *   5 6 4
         *
         *   1、计算深度。
         *   2、直接处理新链表
         *   3、如果存在进位。二次计算
         */
        ListNode t1 = l1.next;
        int[] arr = new int[100];
        arr[0] = l1.val;
        int index = 1;
        int dep = 1;
        while (t1 != null) {
            arr[index] = t1.val;
            index++;
            t1 = t1.next;
            dep++;
        }


        ListNode t2 = l2.next;

        int[] arrt = new int[100];
        arrt[0] = l2.val;
        int index2 = 1;
        int dep1 = 1;
        while (t2 != null) {
            arrt[index2] = t2.val;
            index2++;
            t2 = t2.next;
            dep1++;
        }
        int max = Math.max(dep, dep1);


        int[] arr1 = new int[max];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        int[] arr2 = new int[max];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arrt[i];
        }


        int[] append = new int[100];
        int[] result = new int[max + 1];


        for (int i = 0; i < max; i++) {
            // 第一个值
            int a = arr1[i];
            // 第二个值
            int b = arr2[i];
            // 相加
            int sum = a + b;

            if (append[i] == 1) {
                sum = sum + 1;
            }
            // 需要进位
            if (sum >= 10) {
                append[i + 1] = 1;
            }
            int currNum = sum % 10;

            result[i] = currNum;
        }

        if (append[max] == 1) {
            result[max] = result[max] + 1;
        }


        ListNode root = new ListNode(0);
        ListNode temp = root;
        for (int i = 0; i < result.length; i++) {
            int num = result[i];
            ListNode node = new ListNode(num);
            root.next = node;
            root = root.next;

        }

        ListNode reverse = reverse(temp.next);
        if (reverse.val == 0) {
            reverse = reverse.next;
        }
        return reverse;
    }


}
