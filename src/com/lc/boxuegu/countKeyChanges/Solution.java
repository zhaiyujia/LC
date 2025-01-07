package com.lc.boxuegu.countKeyChanges;



public class Solution {


    public static void main(String[] args) {
        String s = "AaAqwjxzlkaqabsadAsxzcaaA";
        int i = countKeyChanges1(s);
        System.out.println(i);

    }

    public static int countKeyChanges(String s) {

        String s1 = s.toLowerCase();
        int size = s1.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                char c1 = s1.charAt(i);
                char c2 = s1.charAt(i - 1);
                if (c1 != c2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countKeyChanges1(String s) {

        int count = 0;

        int m = 'a' - 'A';
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (a != b && a - b != m && b - a != m) {
                count++;
            }
        }

        return count;
    }

}
