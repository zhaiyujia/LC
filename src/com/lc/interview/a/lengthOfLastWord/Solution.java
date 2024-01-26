package com.lc.interview.a.lengthOfLastWord;

/**
 * @author zhai
 * @date 2023/11/29 9:09 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("---------");
        t2();
        System.out.println("---------");
        t3();
        System.out.println("---------");
    }


    private static void t1() {
        String str = "   fly me   to   the moon  ";
        int i = lengthOfLastWord(str);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        String str = "Hello World";
        int i = lengthOfLastWord(str);
        System.out.println("t2:" + i);
    }

    private static void t3() {
        String str = "luffy is still joyboy";
        int i = lengthOfLastWord(str);
        System.out.println("t3:" + i);
    }

    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int size = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                size++;
            }
            if(size > 0 && s.charAt(i) == ' '){
                break;
            }
        }
        return size;
    }

}
