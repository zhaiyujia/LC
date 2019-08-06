package com.dp.NumArray;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaiyj
 * @date 2019/7/25 9:16
 * @description
 */
public class NumArray {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        /**
         * 重复计算存储
         * 1.0 2 算了一次
         * 2.0 3 的时候，只需要算2 3 的值，然后+ 0 2的值就是sun
         * 3.以前的值怎么存储？
         */
        int sum = obj.sumRange(0, 5);
        System.out.println(sum);
    }

    private int[] data;
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                map.put(new Pair<>(i, j), sum);
//            }
//        }
//        this.data = nums;
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
//        return map.get(new Pair<>(i, j));
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += data[k];
//        }
//        return sum;
    }


}
