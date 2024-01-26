package com.lc.boxuegu.breakfastNumber;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2024/1/23 12:19 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int i = 0;
        int j = drinks.length - 1;
        int res = 0;
        while (i < staple.length && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                res = (res + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        int count = 0;
        for (int i = 0; i < staple.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (staple[i] + drinks[j] <= x) {
                    count = count + 1;
                }
            }
        }
        return count % 1000000007;
    }

    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        long ans = 0;
        int[] arr = new int[x + 1];

        // 此处 arr[i] 中存放的是价格等于 i 的食物的个数
        for (int i : staple)
            if (i <= x)
                arr[i] += 1;
        // 此处 arr[i] 中存放的是价格小于等于 i 的食物的个数
        for (int i = 2; i < x; i++)
            arr[i] += arr[i - 1];

        for (int i : drinks) {
            int lt = x - i;
            if (lt < 0)
                continue;
            ans += arr[lt];
        }

        return (int) (ans % (1000000007));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] staple = new int[]{10, 20, 5};
        int[] drinks = new int[]{5, 5, 2};
        solution.breakfastNumber2(staple, drinks, 15);
    }

}
