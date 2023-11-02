package com.leetcode.interview.a.removeDuplicates;

/**
 * @author zhai
 * @date 2023/11/2 10:49 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution1 {

    public static void main(String[] args) {
        t1();
        System.out.println("---------");
    }

    private static void t1() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = s1(nums);
        System.out.println("t1测试结果：" + i);
        for (int num : nums) {
            System.out.println("t1数组结果：" + num);
        }

    }

    private static int s1(int nums[]) {
        // 0,0,1,1,1,1,2,3,3
        // 1,1,1,2,2,3


        // nums[i] == nums[6]

        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count -2]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }


}
