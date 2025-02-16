package com.lc.boxuegu.S_replaceElements;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        int[] ints = solution.replaceElements2(arr);
        Arrays.stream(ints).forEach(System.out::println);
    }

    // 最快
    public int[] replaceElements4(int[] arr) {
        int max = -1;
        int temp = 0;
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            temp = arr[idx];
            arr[idx] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int mx = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, x); // 维护后缀最大值
        }
        return arr;
    }


    public int[] replaceElements1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; --i) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }


    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                result[i] = -1;
                break;
            }
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(arr[j], max);
            }
            result[i] = max;
        }
        return result;
    }

}
