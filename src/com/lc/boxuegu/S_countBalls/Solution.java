package com.lc.boxuegu.S_countBalls;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lowLimit = 19;
        int highLimit = 28;
        int i = solution.countBalls1(lowLimit, highLimit);
        System.out.println(i);
    }

    public int countBalls1(int lowLimit, int highLimit) {
        int n = highLimit -lowLimit+1;
        int[] counts = new int[highLimit+1];
        int num = getSum(lowLimit)-1;
        int ans = Integer.MIN_VALUE;
        for(int i = lowLimit; i<=highLimit; i++){
            if(i % 10 ==0) {
                num = getSum(i);
            } else {
                num++;
            }
            counts[num]++;
            ans = Math.max(ans, counts[num]);
        }
        return ans;
    }

    private int getSum(int n){
        int ans = 0;
        while(n >0){
            ans +=n %10;
            n /=10;
        }
        return ans;
    }



    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> result = new HashMap<>();

        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int  box =0;
            int x = i;
            while (x > 0 ){
                box += x % 10;
                x = x / 10;
            }
            result.put(box, result.getOrDefault(box, 0) + 1);
            res = Math.max(res, result.get(box));
        }

        return res;
    }

}
