package com.leetcode.maxNumberOfBalloons;

/**
 * @author zhaiyj
 * @date 2019/11/19 9:15 上午
 */
public class Solution {

    public static void main(String[] args) {
        String text = "nlaebolk";
        int x = maxNumberOfBalloons(text);
        System.out.println(x);
    }

    public static int maxNumberOfBalloons(String text) {
        int[] letters = new int[15];
        for (char ch : text.toCharArray()) {
            letters[ch - 97]++;
        }

        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;

        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 97] < min) {
                min = letters[ch - 97];
            }
        }
        return min;

//        int a = 0;
//        int b = 0;
//        int l = 0;
//        int o = 0;
//        int n = 0;
//        int size = text.length();
//        for (int i = 0; i < size; i++) {
//            if(text.charAt(i) == 'a'){
//                a++;
//            }
//            if(text.charAt(i) == 'b'){
//                b++;
//            }
//            if(text.charAt(i) == 'l'){
//                l++;
//            }
//            if(text.charAt(i) == 'o'){
//                o++;
//            }
//            if(text.charAt(i) == 'n'){
//                n++;
//            }
//        }
//        if(a ==0 || b==0 || l==0 | o==0 | n == 0){
//            return 0;
//        }
//
//        // abn 最小值 与lo比较
//        int min = Math.min(a,b);
//        min = Math.min(min,n);
//
//        int lomin = Math.min(l,o);
//
//        if(2*min > lomin){
//            return lomin/2;
//        }else{
//            return min;
//        }
    }

}
