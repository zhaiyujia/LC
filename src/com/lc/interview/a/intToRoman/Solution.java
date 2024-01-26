package com.lc.interview.a.intToRoman;

/**
 * @author zhai
 * @date 2023/12/5 4:01 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        t2();
        t3();
        t4();
        t5();
        t6();
        t7();
    }


    private static void t1() {
        int num = 3;
        String s = intToRoman1(num);
        System.out.println("t1:" + s);
    }

    private static void t2() {
        int num = 4;
        String s = intToRoman1(num);
        System.out.println("t2:" + s);
    }

    private static void t3() {
        int num = 9;
        String s = intToRoman1(num);
        System.out.println("t3:" + s);
    }


    private static void t4() {
        int num = 58;
        String s = intToRoman1(num);
        System.out.println("t4:" + s);
    }

    private static void t5() {
        int num = 1994;
        String s = intToRoman1(num);
        System.out.println("t5:" + s);
    }

    private static void t6() {
        int num = 60;
        String s = intToRoman1(num);
        System.out.println("t6:" + s);
    }

    private static void t7() {
        int num = 101;
        String s = intToRoman1(num);
        System.out.println("t7:" + s);
    }

    public static String intToRoman2(int num) {
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < symbol.length; i++) {
            while(num >= nums[i]) {
                sb.append(symbol[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }



    public static String intToRoman1(int num) {

        String s = toConvert(num);
        if (s.length() > 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int count = 4;
        int x = 0;
        int chushu = 10000;
        int cs = 1000;
        while (count > 0) {
            num = num - (x * chushu);
            int bw = num / cs;
            if (bw != 0) {
                x = bw;
                String s1 = toConvert(bw * cs);
                if (s1.length() > 0) {
                    sb.append(s1);
                } else {
                    if (bw > 5 && bw < 9) {
                        sb.append(toConvert(5 * cs));
                        bw = bw - 5;
                    }
                    for (int i = 0; i < bw; i++) {
                        sb.append(toConvert(cs));
                    }
                }
            } else {
                x = 0;
            }
            cs = cs / 10;
            chushu = chushu / 10;
            count--;
        }
        return sb.toString();
    }


    public static String intToRoman(int num) {

        String s = toConvert(num);
        if (s.length() > 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        // 获取千位数
        int qw = num / 1000;
        if (qw != 0) {
            String s1 = toConvert(1000);
            for (int i = 0; i < qw; i++) {
                sb.append(s1);
            }
        }

        // 获取百位数
        num = num - (qw * 1000);
        int bw = num / 100;
        int bwe = bw;
        if (bw != 0) {
            String s1 = toConvert(bw * 100);
            if (s1.length() > 0) {
                sb.append(s1);
            } else {
                if (bw > 5 && bw < 9) {
                    sb.append(toConvert(500));
                    bw = bw - 5;
                }
                for (int i = 0; i < bw; i++) {
                    sb.append(toConvert(100));
                }
            }
        }

        // 获取十位数
        num = num - (bwe * 100);
        int sw = num / 10;
        int swe = sw;
        if (sw != 0) {
            String s1 = toConvert(sw * 10);
            if (s1.length() > 0) {
                sb.append(s1);
            } else {
                if (sw > 5 && sw < 9) {
                    sb.append(toConvert(50));
                    sw = sw - 5;
                }
                for (int i = 0; i < sw; i++) {
                    sb.append(toConvert(10));
                }
            }
        }

        // 获取个位数
        int gw = num - (swe * 10);
        if (gw != 0) {
            String s1 = toConvert(gw);
            if (s1.length() > 0) {
                sb.append(s1);
            } else {
                if (gw > 5 && gw < 9) {
                    sb.append(toConvert(5));
                    gw = gw - 5;
                }
                for (int i = 0; i < gw; i++) {
                    sb.append(toConvert(1));
                }
            }
        }


        return sb.toString();
    }

    public static String toConvert(int i) {
        switch (i) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            case 4:
                return "IV";
            case 9:
                return "IX";
            case 40:
                return "XL";
            case 90:
                return "XC";
            case 400:
                return "CD";
            case 900:
                return "CM";
        }
        return "";
    }

}
