package com.lc.easy.numTilePossibilities;

/**
 * @author zhaiyj
 * @date 2019/11/12 9:08 上午
 */
public class Solution {

    public static void main(String[] args) {
        String tiles = "AB";
        numTilePossibilities(tiles);
    }

    public static int numTilePossibilities(String tiles) {
        int[] counter = new int[2];
        for (int i = 0; i < tiles.length(); i++) {
            counter[tiles.charAt(i) - 'A'] ++;
        }
        int x =  dfs(counter);
        System.out.println(x);
        return x;
    }

    public static int dfs(int[] counter){
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            if(counter[i] > 0){
                int x = counter[i];
                sum++;
                counter[i]--;
                sum += dfs(counter);
                counter[i]++;
            }
        }
        return sum;
    }

}
