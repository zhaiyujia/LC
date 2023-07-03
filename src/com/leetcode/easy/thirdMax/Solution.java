package com.leetcode.easy.thirdMax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhai
 * @date 2021/5/17 下午3:34
 * @illustration
 * @slogan:
 * @version: 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 去重复
 * 排序
 * nums[3]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3};
        int i = thirdMax1(nums);
        System.out.println(i);
    }


    public static int thirdMax1(int[] nums) {
        // 记录最大的前三个数
        long a = (long) Integer.MIN_VALUE - 1;
        long b = (long) Integer.MIN_VALUE - 1;
        long c = (long) Integer.MIN_VALUE - 1;
        int count = 0;
        for (int num : nums) {
            if (num > a) {
                count++;
                c = b;
                b = a;
                a = num;
            } else if (num > b && num != a) {
                count++;
                c = b;
                b = num;
            } else if (num > c && num != a && num != b) {
                count++;
                c = num;
            }
        }
        return (int) (count > 2 ? c : a);
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            if (ans.contains(i)) {
                continue;
            }
            ans.add(i);
        }

        int n = ans.size();
        if (n == 1 || n == 2) {
            return ans.get(n - 1);
        }

        return ans.get(ans.size() - 3);
    }

}
