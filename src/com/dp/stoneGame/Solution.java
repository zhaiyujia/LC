package com.dp.stoneGame;

/**
 * @author zhaiyj
 * @date 2019/8/8 9:05
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        stoneGame(piles);
    }

    public static boolean stoneGame(int[] piles) {

        int N = piles.length;
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 0; size <= N; ++size) {
            for (int i = 0; i + size < N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;
                if(parity==1){
                    dp[i+1][j+1] = Math.max(piles[i]+dp[i+2][j+1],piles[j]+dp[i+1][j]);
                }else{
                    dp[i+1][j+1] = Math.min(-piles[i]+dp[i+2][j+1],-piles[j]+dp[i+1][j]);
                }
            }
        }
        return dp[1][N] > 0;

//        if (piles.length==2) {
//            return true;
//        }
//        int y = 0;
//        int l = 0;
//        int size = piles.length;
//        for (int i = 0; i < size; i+=2) {
//            y = y + piles[i];
//            l = l + piles[i+1];
//        }
//        if(y>l){
//            return true;
//        }
//        return false;


    }

}
