package com.lc.interview.a.longestCommonPrefix;

/**
 * @author zhai
 * @date 2023/12/4 2:34 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
        t1();
        System.out.println("--------------");
        t2();
        System.out.println("--------------");
        t3();
        System.out.println("--------------");
        t4();
        System.out.println("--------------");
    }

    private static void t1() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = longestCommonPrefix1(strs);
        System.out.println("t1:" + s);
    }


    private static void t2() {
        String[] strs = new String[]{"dog", "racecar", "car"};
        String s = longestCommonPrefix1(strs);
        System.out.println("t2:" + s);
    }

    private static void t3() {
        String[] strs = new String[]{"", "b"};
        String s = longestCommonPrefix1(strs);
        System.out.println("t3:" + s);
    }

    private static void t4() {
        String[] strs = new String[]{"aaa", "aa", "aaa"};
        String s = longestCommonPrefix1(strs);
        System.out.println("t4:" + s);
    }

    public static String longestCommonPrefix1(String[] strs) {
        String ans = strs[0];
        for (String str : strs) {
            while (!str.startsWith(ans)){
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }


    public static String longestCommonPrefix(String[] strs) {

        String pre = strs[0];
        if (pre.equals("")) {
            return "";
        }
        int size = pre.length();
        for (String str : strs) {
            boolean b = str.startsWith(pre);
            if (b) {
                if (pre.length() > str.length()) {
                    pre = str;
                }
            } else {
                while (size > 0) {
                    pre = pre.substring(0, size - 1);
                    if (pre.equals("")) {
                        return "";
                    }
                    boolean c = str.startsWith(pre);
                    if (c) {
                        break;
                    } else {
                        size--;
                    }
                }
            }
        }
        return pre;
    }

}
