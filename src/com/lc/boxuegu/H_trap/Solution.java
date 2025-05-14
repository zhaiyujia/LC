package com.lc.boxuegu.H_trap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhaiyj
 * @date 2025/5/14 20:43
 */
public class Solution {

    public static void main(String[] args) {

    }


    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] >= height[st.peek()]){
                int bootomH = height[st.pop()];
                if(st.isEmpty()){
                    break;
                }

                int left = st.peek();
                int dh = Math.min(height[left], height[i]) - bootomH;
                ans += dh * (i - left - 1);
            }
            st.push(i);
        }
        return ans;
    }


    public int trap2(int[] height) {

        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int sufMax = 0;
        while (left <= right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);

            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }

    public int trap1(int[] height) {
        int n = height.length;

        int[] pre_max = new int[n];
        pre_max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            pre_max[i] = Math.max(pre_max[i - 1], height[i]);
        }


        int[] suf_max = new int[n];
        suf_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf_max[i] = Math.max(suf_max[i + 1], suf_max[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(pre_max[i], suf_max[i]) - height[i];
        }

        return ans;


    }

}
