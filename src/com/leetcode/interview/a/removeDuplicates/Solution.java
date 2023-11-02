package com.leetcode.interview.a.removeDuplicates;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhai
 * @date 2023/11/2 10:12 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
        t1();
        System.out.println("----------");
        t2();
    }

    private static void t1() {
        int[] nums = new int[]{1, 1, 2};
        int i = removeDuplicates1(nums);
        System.out.println("t1测试结果:" + i);
        for (int num : nums) {
            System.out.println("t1->num:" + num);
        }
    }

    private static void t2() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates1(nums);
        System.out.println("t2测试结果:" + i);
        for (int num : nums) {
            System.out.println("t2->num:" + num);
        }
    }


    public static int removeDuplicates(int[] nums) {

        /**
         * 双指针
         * Set集合
         */

        Set<Integer> exist = new HashSet<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!exist.contains(nums[i])) {
                nums[start] = nums[i];
                start++;
                exist.add(nums[i]);
            }
        }
        return start;
    }



    public static int removeDuplicates1(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[start] != nums[i]){
                nums[++start] = nums[i];
            }
        }
        return ++start;
    }


}
