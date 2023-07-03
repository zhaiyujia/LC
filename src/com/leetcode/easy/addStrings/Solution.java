package com.leetcode.easy.addStrings;

/**
 * @author zhai
 * @date 2021/5/17 下午5:03
 * @illustration
 * @slogan:
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        String s1 = "123456789";
        String s2 = "987654321";
        String s = addStrings(s1, s2);
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2){
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static String addStrings2(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        char[] max = null;
        char[] min = null;
        int cha = 0;
        if (c1.length >= c2.length) {
            max = c1;
            min = c2;
            cha = c1.length - c2.length;
        } else {
            max = c2;
            min = c1;
            cha = c2.length - c1.length;
        }
        int index = 0;
        for (int i = max.length - 1; i >= 0; i--) {
            int x = 0;
            if(i > max.length - 1 - min.length){
                x = (int) max[i] + (int) min[i - cha] - 96;
            }else{
                x = (int) max[i] - 48;
            }
            if (index != 0) {
                x = x + 1;
                index = 0;
            }
            if (x >= 10) {
                index = 1;
                x = x % 10;
            }
            builder.append(x);
        }
        if(index != 0){
            builder.append(1);
        }
        return builder.reverse().toString();
    }


    public static String addStrings1(String num1, String num2) {
        String str = "";
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int index = 0;
        if (c1.length > c2.length) {
            for (int i = c2.length - 1; i > 0; i--) {
                char v2 = c2[i];
                char v1 = c1[i];
                System.out.println(v1 + v2);
                int x = (int) v1 + (int) v2;
                if (index != 0) {
                    x = x + 1;
                    index = 0;
                }
                int v = 0;
                if (x > 10) {
                    index = 1;
                    v = x % 10;
                    str = str + v;
                }
            }
        }
        return str;
    }

}
