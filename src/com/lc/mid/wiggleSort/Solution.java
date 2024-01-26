package com.lc.mid.wiggleSort;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2023/7/10 4:01 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
//        int[] nums = {1, 3, 2, 2, 3, 1};
        // x < y > z
        wiggleSort(nums);
        System.out.println(nums);
    }

    public static void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] += 1;
        }
        int len = nums.length;
        int big, small;
        if (len % 2 == 1) {
            small = len - 1;
            big = len - 2;
        } else {
            big = len - 1;
            small = len - 2;
        }
        int max = 5000;
        //大数
        for (int i = 1; i <= big; i += 2) {
            while (bucket[max] == 0) {
                max--;
            }
            nums[i] = max;
            bucket[max] -= 1;
        }

        //小数
        for (int i = 0; i <= small; i += 2) {
            while (bucket[max] == 0) {
                max--;
            }
            nums[i] = max;
            bucket[max] -= 1;
        }
    }

    public static void wiggleSort1(int[] nums) {

        int[] temp = new int[nums.length];
        Arrays.sort(nums);
        int j = nums.length - 1;
        for (int i = 1; i < nums.length; i = i + 2, j--) {
            temp[i] = nums[j];
        }
        for (int i = 0; i < nums.length; i = i + 2, j--) {
            temp[i] = nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

//
//        for (int i = 0; i < nums.length; i++) {
//            // 偶数位 <
//            if (i % 2 == 0) {
//                if (nums[i] < nums[i + 1]) {
//                    continue;
//                }
//                for (int j = i + 1; j < nums.length; j++) {
//                    /**
//                     * 如果
//                     *  j的位置 大于 i的位置，不进行任何操作
//                     *  j的位置 小于 i的位置，需要换位置
//                     *    如果 j+x > i  j 与 j+x换位置
//                     */
//                    if (nums[j] < nums[i]) {
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                        break;
//                    }
//                }
//            }
//            // 奇数位 >
//            if (i % 2 == 1) {
//                if (nums[i] > nums[i + 1] && i < nums.length - 1) {
//                    continue;
//                }
//                for (int j = i + 1; j < nums.length; j++) {
//                    /**
//                     * 如果
//                     *  j的位置 小于 i的位置，不进行任何操作
//                     *  j的位置 大于 i的位置，需要换位置
//                     *    如果 j+x > i  j 与 j+x换位置
//                     */
//                    if (nums[j] > nums[i]) {
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                        break;
//                    }
//                }
//
//            }
//        }
    }

}
