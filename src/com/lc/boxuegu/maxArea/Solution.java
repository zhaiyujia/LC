package com.lc.boxuegu.maxArea;

/**
 * @author zhai
 * @date 2024/1/17 7:10 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version: https://leetcode.cn/problems/container-with-most-water/description/
 */
public class Solution {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea2(height);
        System.out.println(i);
    }



    // 暴力解法，直接穷举

    /**
     * 暴力解法，直接穷举
     * 直接就是一个超时
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int size = height.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            // 当前接水量
            for (int j = i + 1; j < size; j++) {
                // 取最小的存水量
                int min =Math.min(height[j], height[i]);
                // 计算两个位置之间的距离
                int distance = j - i;
                // 计算面积, 面积 = 最小节水量 * 距离
                int area = distance * min;
                // 取当前面积与之前的面积对比，取最大只
                ans = Math.max(ans, area);
            }
        }
        // 返回最大容水量
        return ans;
    }


    public static int maxArea2(int[] height) {
        //
        int i = 0;
        int j = height.length - 1;
        int min, max=0;
        while(i<j){
            min = Math.min(height[i],height[j]);
            max = Math.max(min * (j-i),max);
            while(i<j && height[i] <= min) {
                i++;
            }
            while(i<j && height[j] <= min) {
                j--;
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {
        // 左指针，指向最左边位置
        int l = 0;
        // 右指针，指向最右位置
        int r = height.length - 1;
        // 容水量 设置为0
        int ans = 0;
        // 左指针 小于 右指针
        while (l < r) {
            // 计算面积 面积 = 最小容水量 * 两位置之间的距离
            int area = Math.min(height[l], height[r]) * (r - l);
            // 取最大的容水量
            ans = Math.max(ans, area);
            // 如果 左指针指向的容水高度 <= 右指针指向的融水高度，则让左指针+1，反之让右指针-1
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        // 返回最大融水量
        return ans;
    }

}
