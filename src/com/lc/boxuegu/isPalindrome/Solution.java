package com.lc.boxuegu.isPalindrome;

/**
 * @author zhai
 * @date 2024/1/29 4:51 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int x = 146641;
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }


    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        //  负数或者是结尾是0的，肯定不是回文数，除了本身为0以外
        if (x < 0 || (x % 10 == 0)) {
            return false;
        }

        int revertNumber = 0;

        // 将x的后半段反转，构建一个新的数和x的前半段比较
        while (x > revertNumber) {// x的位数在缩小，revertNumber 在增大
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertNumber || x == revertNumber / 10;
    }

}
