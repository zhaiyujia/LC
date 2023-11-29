package com.leetcode.interview.a.romanToInt;

import java.util.*;

/**
 * @author zhai
 * @date 2023/11/28 9:09 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("---------------");
        t2();
        System.out.println("---------------");
        t3();
        System.out.println("---------------");
        t4();
        System.out.println("---------------");
        t5();
        System.out.println("---------------");
    }


    private static void t1() {
        String str = "III";
        int i = romanToInt3(str);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        String str = "IV";
        int i = romanToInt3(str);
        System.out.println("t2:" + i);
    }

    private static void t3() {
        String str = "IX";
        int i = romanToInt3(str);
        System.out.println("t3:" + i);
    }

    private static void t4() {
        String str = "LVIII";
        int i = romanToInt3(str);
        System.out.println("t4:" + i);
    }

    private static void t5() {
        String str = "MCMXCIV";
        int i = romanToInt3(str);
        System.out.println("t5:" + i);
    }


    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static int romanToInt3(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            }else{
                ans += value;
            }
        }
        return ans;
    }


    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }


    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }

    public static int romanToInt2(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }


    public static int romanToInt1(String s) {

        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && ((s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ||
                    (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ||
                    (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))
            ) {
                sum += map.get(String.valueOf(s.charAt(i)).concat(String.valueOf(s.charAt(i + 1))));
                i += 1;
            } else {
                sum += map.get(String.valueOf(s.charAt(i)));
            }
        }

        return sum;
    }


    public static int romanToInt(String s) {

        // IV = 4
        // IX = 9
        // XL = 40
        // XC = 1000
        // CD = 400
        // CM = 1000
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I' && i < n - 1) {
                char c = s.charAt(i + 1);
                if (c == 'V' || c == 'X') {
                    sum += map.get(String.valueOf(s.charAt(i)).concat(String.valueOf(c)));
                    i += 1;
                } else {
                    sum += map.get(String.valueOf(s.charAt(i)));
                }
                continue;
            }
            if (s.charAt(i) == 'X' && i < n - 1) {
                char c = s.charAt(i + 1);
                if (c == 'L' || c == 'C') {
                    sum += map.get(String.valueOf(s.charAt(i)).concat(String.valueOf(c)));
                    i += 1;
                } else {
                    sum += map.get(String.valueOf(s.charAt(i)));
                }
                continue;
            }
            if (s.charAt(i) == 'C' && i < n - 1) {
                char c = s.charAt(i + 1);
                if (c == 'D' || c == 'M') {
                    sum += map.get(String.valueOf(s.charAt(i)).concat(String.valueOf(c)));
                    i += 1;
                } else {
                    sum += map.get(String.valueOf(s.charAt(i)));
                }
                continue;
            }
            sum += map.get(String.valueOf(s.charAt(i)));
        }

        return sum;
    }


}
