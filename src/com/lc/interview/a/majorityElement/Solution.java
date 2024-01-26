package com.lc.interview.a.majorityElement;

import java.util.*;

/**
 * @author zhai
 * @date 2023/11/3 10:16 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
        t1();
        System.out.println("----");
        t2();
        System.out.println("----");
        t3();
        System.out.println("----");
        t4();

    }


    private static void t1() {
        int[] nums = new int[]{3, 2, 3};
        int i = majorityElement3(nums);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement3(nums);
        System.out.println("t2:" + i);
    }

    private static void t3() {
        int[] nums = new int[]{1};
        int i = majorityElement3(nums);
        System.out.println("t3:" + i);
    }

    private static void t4() {
        int[] nums = new int[]{3, 3, 4};
        int i = majorityElement3(nums);
        System.out.println("t4:" + i);
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num, integer + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) > size / 2) {
                return integer;
            }
        }
        return 0;
    }


    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

//        int size = nums.length;
//        int count = 1;
//        int left = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[left] == nums[i]) {
//                count++;
//            }
//
//            if (nums[left] != nums[i]) {
//                if (count > size / 2) {
//                    return nums[left];
//                } else {
//                    count = 1;
//                }
//                left = i;
//            }
//        }
//        if (count > size / 2) {
//            return nums[size - 1];
//        }
//        return 0;
    }

    /**
     * 最暴力
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > size / 2) {
                return nums[i];
            }
        }
        return 0;
    }


    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {

        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    public static int majorityElement4(int[] nums) {
        return execute(nums, 0);
    }



    public static int execute(int[] nums, int index) {
        int count = 1;
        for(int i = index + 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                count++;
            } else if (--count < 1) {
                return execute(nums, i + 1);
            }
        }
        return nums[index];
    }


}
