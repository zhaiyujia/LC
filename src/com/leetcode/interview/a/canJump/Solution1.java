package com.leetcode.interview.a.canJump;

/**
 * @author zhai
 * @date 2023/11/16 7:07 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution1 {

    public static void main(String[] args) {
        t1();
//        System.out.println("---------");
//        t2();
//        System.out.println("---------");
//        t3();
//        System.out.println("---------");
//        t4();
//        System.out.println("---------");
//        t5();
    }


    private static void t1() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int jump = jump1(nums);
        System.out.println("t1:" + jump);
    }

    private static void t2() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        int jump = jump(nums);
        System.out.println("t2:" + jump);
    }

    private static void t3() {
        int[] nums = new int[]{6, 3, 0, 1, 4};
        int jump = jump(nums);
        System.out.println("t3:" + jump);
    }

    private static void t4() {
        int[] nums = new int[]{1, 2};
        int jump = jump(nums);
        System.out.println("t4:" + jump);
    }

    private static void t5() {
        int[] nums = new int[]{1, 1, 1, 1};
        int jump = jump1(nums);
        System.out.println("t5:" + jump);
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int jumpEnd = nums.length - 1;
        int length = nums.length - 2;
        int count = 0;

        int minIndex = Integer.MAX_VALUE;
        while (true) {
            for (int j = length; j >= 0; j--) {
                if (j + nums[j] >= jumpEnd - j) {
                    minIndex = Math.min(minIndex, j);
                }
            }
            if (minIndex == 0) {
                count += 1;
                break;
            } else {
                jumpEnd = minIndex;
                length = minIndex - 1;
                count++;
            }
        }

        return count;
    }

    public static int jump1(int nums[]) {
        int maxCover = 0; //最大覆盖值
        int cover = 0;    //覆盖值
        int minStep = 0;   //最小步数
        if (nums.length == 1) {
            return minStep;
        }
        for (int i = 0; i <= cover; i++) {
            if (i + nums[i] > cover && i + nums[i] > maxCover) {
                maxCover = i + nums[i];    //如果比maxCover大就更新maxCover的值为i+nums[i]
                if (maxCover >= nums.length - 1) {
                    minStep += 1;  //最大覆盖值可以覆盖到nums[n-]即为最小步数
                    break;
                }
            }
            if (i == cover) {
                cover = maxCover;  //更新搜索范围
                minStep += 1;      //范围更新说明跳出原先的覆盖区间cover，所以步数肯定+1
            }
        }
        return minStep;
    }


}
