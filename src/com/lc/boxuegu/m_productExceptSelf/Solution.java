package com.lc.boxuegu.m_productExceptSelf;

/**
 * @author zhaiyj
 * @date 2025/5/12 20:44
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution s = new Solution();
        int[] ints = s.productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }


    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;

        int[] l = new int[nums.length];
        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }


        int[] r = new int[nums.length];
        r[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = l[i] * r[i];
        }

        return answer;
    }


    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    tmp *= nums[j];
                }
            }
            res[i] = tmp;
        }
        return res;
    }

}
