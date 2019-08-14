package com.dp.countBits;

/**
 * @author zhaiyj
 * @date 2019/8/6 8:56
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int num = 4;
        countBits(num);
//        System.out.println(1 & (1-1));
    }

    private static int popCount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x &= x - 1;
        }
        return count;
    }

    public static int[] countBits(int num) {

        int[] ans = new int[num + 1];
        int i = 0;
        int b = 1;
        while (b <= num) {
            while (i < b && i + b <= num){
                ans[i+b] = ans[i]+1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return ans;

//        int[] ans = new int[num+1];
//        for (int i = 0; i <= num; i++) {
//            ans[i] = popCount(i);
//        }
//        return ans;

//        int[] res = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            res[i] = res[i & (i - 1)] + 1;
//        }
//        return res;
//        int[] res = new int[num+1];
//        for (int i = 0; i <= num; i++) {
//            String str = Integer.toBinaryString(i);
//            int index = 0;
//            for (int j = 0; j < str.length(); j++) {
//                if(str.charAt(j)=='1'){
//                    index++;
//                }
//            }
//            res[i] = index;
//        }
//        return res;
    }

}
