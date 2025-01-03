package com.lc.boxuegu.plusOne;

/**
 * @author zhai
 * @date 2024/1/22 6:21 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{9, 3, 9, 9};
        int[] ints = solution.plusOne3_2(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public int[] plusOne1_1(int[] digits) {
        int array = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (digits[i] + array) % 10;
            array = (temp + array) / 10;
            if (array == 0) {
                break;
            }

        }

        if (array > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }


    public int[] plusOne2_1(int[] digits) {

        int array = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            digits[i] = (digit + array) % 10;
            array = (digit + array) / 10;
            if (array == 0) {
                break;
            }
        }
        if (array > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

    public int[] plusOne3_1(int[] digits) {
        int temp = 1;
        int index = digits.length - 1;
        for (int i = index; i >= 0; i--) {

            int curr = (digits[i] + temp) % 10;
            temp = (digits[i] + temp) / 10;
            digits[i] = curr;
        }

        if (temp == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }


    public int[] plusOne3_2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

}
