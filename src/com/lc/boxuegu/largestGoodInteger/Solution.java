package com.lc.boxuegu.largestGoodInteger;

public class Solution {

    public static void main(String[] args) {
        String num = "1134324999";
        String s = largestGoodInteger1(num);
        System.out.println(s);
    }


    public static String largestGoodInteger(String num) {
        int size = num.length();
        char c = num.charAt(0);
        char max = '0' - 1;
        int count = 0;
        for (int i = 1; i < size; i++) {
            char x = num.charAt(i);
            if (c == x) {
                count++;
            } else {
                count = 0;
            }
            if (count == 2) {
                max = max > c ? max : c;
                count = 0;
            }
            c = x;
        }

        if (max < '0') {
            return "";
        }

        return "" + max + max + max;
    }

    public static String largestGoodInteger1(String num) {
        if (num.contains("999")) return "999";
        if (num.contains("888")) return "888";
        if (num.contains("777")) return "777";
        if (num.contains("666")) return "666";
        if (num.contains("555")) return "555";
        if (num.contains("444")) return "444";
        if (num.contains("333")) return "333";
        if (num.contains("222")) return "222";
        if (num.contains("111")) return "111";
        if (num.contains("000")) return "000";
        return "";
    }

    public static String largestGoodInteger2(String num) {
        int n = num.length();
        String res = "";
        for (int i = 0; i < n - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {

                String current = num.substring(i, i + 3);
                if (res.compareTo(current) < 0) {
                    res = current;
                }

            }
        }
        return res;
    }

}
