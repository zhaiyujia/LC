package com.lc.boxuegu.minOperations1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,11,10,1,3};
        int k = 10;
        int i = minOperations1(nums, k);
        System.out.println(i);
    }

    public static int minOperations1(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue();

        for (long num : nums) {
            queue.offer(num);
        }

        int res = 0;
        while (queue.peek() < k) {
            long x = queue.poll();
            long y = queue.poll();

            queue.offer(x + x + y);
            res++;
        }

        return res;
    }

    public static int minOperations(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }

        // 先排序
        Arrays.sort(nums);

        // 如果最小值已经大于等于k，不需要操作
        if (nums[0] >= k) {
            return 0;
        }

        // 使用ArrayList便于操作
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;
        while (list.size() >= 2) {
            // 如果最小值已经大于等于k，结束操作
            if (list.get(0) >= k) {
                return operations;
            }

            // 取出最小的两个数
            int x = list.remove(0);
            int y = list.remove(0);

            // 计算新值
            long newValue = (long) x * 2 + y;
            // 确保不超过Integer.MAX_VALUE
            newValue = Math.min(newValue, Integer.MAX_VALUE);

            // 找到合适的插入位置（保持有序）
            int insertPos = 0;
            while (insertPos < list.size() && list.get(insertPos) < newValue) {
                insertPos++;
            }
            list.add(insertPos, (int) newValue);

            operations++;
        }

        // 检查最后一个数是否大于等于k
        return list.get(0) >= k ? operations : operations + 1;
    }

}
