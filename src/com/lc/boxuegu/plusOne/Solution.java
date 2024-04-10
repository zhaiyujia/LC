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
        int[] nums = new int[]{9};
        int[] ints = solution.plusOne2_1(nums);
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
            if(array == 0){
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

}
