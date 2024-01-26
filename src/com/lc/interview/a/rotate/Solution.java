package com.lc.interview.a.rotate;

import java.util.Stack;

/**
 * @author zhai
 * @date 2023/11/6 10:24 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("-----------");
        t2();
        System.out.println("-----------");
        t3();
        System.out.println("-----------");
        t4();
        System.out.println("-----------");
        t5();
    }

    private static void t1() {
        // 5,6,7,1,2,3,4
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate4(nums, 3);
        for (int num : nums) {
            System.out.println("t1:" + num);
        }
    }

    private static void t2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        rotate4(nums, 2);
        for (int num : nums) {
            System.out.println("t2:" + num);
        }
    }

    private static void t3() {
        int[] nums = new int[]{1, 2};
        rotate4(nums, 3);
        for (int num : nums) {
            System.out.println("t3:" + num);
        }
    }

    private static void t4() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate4(nums, 11);
        for (int num : nums) {
            System.out.println("t4:" + num);
        }
    }

    private static void t5() {
        int[] nums = new int[]{-1};
        rotate4(nums, 2);
        for (int num : nums) {
            System.out.println("t5:" + num);
        }
    }

    private static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    private static void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    private static void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        // 计算实际移动需要移动的位置
        int size = nums.length;
        k = k % size;
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int next = (size - 1) - i;
            int newIndex = 0;
            if (next >= k) {
                newIndex = i + k;
            } else {
                newIndex = k - next - 1;
            }
            nums1[newIndex] = nums[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
    }

    public static void rotate1(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int size = nums.length;
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int in = size - i - 1;
            int cha = k - in;
            if (cha > 0) {
                int newIndex = 0;
                if (cha > size) {
                    newIndex = cha / size - 1;
                } else {
                    newIndex = cha - 1;
                }
                nums1[newIndex] = nums[i];
            } else {
                nums1[i + k] = nums[i];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
    }

    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        if (size == 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i > nums.length - k - 1; i--) {
            stack.add(nums[i]);
        }


        int index = nums.length - k - 1;
        for (int i = index; i >= 0; i--) {
            nums[size - 1] = nums[i];
            size--;
        }

        int s = 0;
        while (!stack.isEmpty()) {
            nums[s] = stack.pop();
            s++;
        }
    }

}
