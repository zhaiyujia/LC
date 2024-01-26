package com.lc.easy.guessnumber;

import com.dp.Utils;

/**
 * Created by zhaiyj
 * date 2019/11/4 9:18 上午
 */
public class Solution {

    public static void main(String[] args) {
        int []  guess = new int[3];
        guess[0] = 1;
        guess[1] = 2;
        guess[2] = 3;

        int []  answer = new int[3];
        answer[0] = 1;
        answer[1] = 3;
        answer[2] = 2;
        int result = game(guess,answer);
        Utils.println(result);
    }

    public static int game(int[] guess, int[] answer) {
        int index = 0;
        for (int i=0;i<answer.length;i++){
            int guessNumber = guess[i];
            int currentNumber = answer[i];
            if(guessNumber == currentNumber){
                index ++;
            }
        }
        return index;
    }

}
