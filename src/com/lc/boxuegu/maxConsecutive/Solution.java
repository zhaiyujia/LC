package com.lc.boxuegu.maxConsecutive;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int bottom = 6;
        int top = 8;
        int[] special = new int[]{7, 6, 8};
        int ans = maxConsecutive(bottom, top, special);
        System.out.println(ans);
    }


    public static int maxConsecutive(int bottom, int top, int[] special) {

        int ans = 0;
        int length = special.length;
        Arrays.sort(special);

        ans = Math.max(ans, special[0] - bottom);

        for (int i = 1; i < length; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }

        ans = Math.max(ans, top - special[length - 1]);

        return ans;
    }


}
