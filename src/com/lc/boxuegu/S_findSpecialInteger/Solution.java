package com.lc.boxuegu.S_findSpecialInteger;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,2,2,3,3,3,3};
        int specialInteger = solution.findSpecialInteger(arr);
        System.out.println(specialInteger);
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int curr = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curr) {
                cnt++;
                if(cnt * 4 > n ){
                    return curr;
                }
            }else{
                curr = arr[i];
                cnt = 1;
            }
        }
        return curr;
    }

}
