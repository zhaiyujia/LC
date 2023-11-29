package com.leetcode.interview.a.isPalindrome;

/**
 * @author zhai
 * @date 2023/11/24 9:07 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("--------");
        t2();
        System.out.println("--------");
        t3();
        // A = 65
        // Z = 90
        // a = 97
        // z = 122
        // 0 = 48
        // 9 = 57
    }


    private static void t1() {
        String s = "race a car";
        boolean palindrome = isPalindrome1(s);
        System.out.println("t1:" + palindrome);
    }

    private static void t2() {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome1(s);
        System.out.println("t2:" + palindrome);
    }

    private static void t3() {
        String s = "0P";
        boolean palindrome = isPalindrome1(s);
        System.out.println("t3:" + palindrome);
    }


    public static boolean isPalindrome1(String s) {

        return s.replaceAll("[^0-9a-zA-Z]","")
                .toLowerCase()
                .equals(new StringBuilder(s.replaceAll("[^0-9a-zA-Z]","")
                        .toLowerCase())
                        .reverse()
                        .toString());
    }


    public static boolean isPalindrome(String s) {

        // A = 65
        // Z = 90
        // a = 97
        // z = 122

        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int ass = (int) s.charAt(i);
            // 数字
            if (ass >= 48 && ass <= 57) {
                nums[i] = ass;
            } else if (ass >= 65 && ass <= 90) {
                nums[i] = ass + 32;
            } else if (ass >= 97 && ass <= 122) {
                nums[i] = ass;
            } else {
                nums[i] = 0;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                left++;
                continue;
            }
            if (nums[right] == 0) {
                right--;
                continue;
            }

            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
//
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            int a = (int) s.charAt(left);
//            int b = (int) s.charAt(right);
//
//            // 判断是否为字母
//            if (a < 65 || (a > 90 && a < 97) || a > 122) {
//                left++;
//                continue;
//            }
//
//            if (b < 65 || (b > 90 && b < 97) || b > 122) {
//                right--;
//                continue;
//            }
//
//            if (a >= 65 && a <= 90) {
//                a += 32;
//            }
//
//            if (b >= 65 && b <= 90) {
//                b += 32;
//            }
//
//            if (a == b) {
//                left++;
//                right--;
//            } else {
//                return false;
//            }
//        }
//        return true;
    }

}
