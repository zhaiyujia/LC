package com.lc.lingGod.M_twoSum;

/**
 * @author zhaiyj
 * @date 2025/5/19 21:21
 */
public class Solution {


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                break;
            }
            if(sum > target){
                right --;
            }else{
                left ++;
            }
        }

        return new int[]{left + 1, right + 1};
    }


}
