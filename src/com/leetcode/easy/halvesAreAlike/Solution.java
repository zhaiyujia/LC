package com.leetcode.easy.halvesAreAlike;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhai
 * @date 2023/11/29 9:26 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    static List<Character> list = new ArrayList<>() {
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }
    };

    public static void main(String[] args) {
        t1();
        System.out.println("---------");
        t2();
        System.out.println("---------");
    }

    private static void t1() {
        String str = "book";
        boolean b = halvesAreAlike3(str);
        System.out.println("t1:" + b);
    }

    private static void t2() {
        String str = "textbook";
        boolean b = halvesAreAlike3(str);
        System.out.println("t2:" + b);
    }

    private static int t(char ch, int count) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                count++;
                break;
            default:
                break;
        }
        return count;
    }

    public static boolean halvesAreAlike3(String s) {

        int n = s.length();
        int count = 0;
        int count1 = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            count = t(s.charAt(i), count);
            count1= t(s.charAt(j), count1);
        }
        return count == count1;
    }


    public static boolean halvesAreAlike2(String s) {

        int n = s.length();
        int count = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {

            if (list.contains(s.charAt(i))) {
                count++;
            }
            if (list.contains(s.charAt(j))) {
                count--;
            }
        }
        return count == 0;
    }


    public static boolean halvesAreAlike(String s) {

        int index = s.length() / 2 - 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (list.contains(s.charAt(i))) {
                if (i <= index) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return count == 0;

    }

}
