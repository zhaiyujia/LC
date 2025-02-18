package com.lc.boxuegu.M_RangeFreqQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {

    int[] frequency;
    int[] valueArray;
    int length;

    public RangeFreqQuery(int[] arr) {
        valueArray = arr;
        length = arr.length;
        frequency = new int[length];
        HashMap<Integer,Integer> frequencyMap = new HashMap();
        for(int i = 0; i< length;i++){
            int num = arr[i];
            if(!frequencyMap.containsKey(num)){
                frequency[i] = 1;
                frequencyMap.put(num, 1);
            }
            else{
                frequency[i] = frequencyMap.get(num) +1;
                frequencyMap.put(num, frequency[i]);
            }
        }
    }

    public int query(int left, int right, int value) {
        int L = left, R = right;
        while(L < right){
            if(valueArray[L] == value){
                break;
            }
            L++;
        }
        if(valueArray[L] != value){
            return 0;
        }
        while(R >= L){
            if(valueArray[R] == value){
                break;
            }
            R--;
        }
        return frequency[R] - frequency[L] +1;
    }
//
//    private int[] arr;
//
//    private Map<Integer, List<Integer>> occurrence;
//
//
//    public RangeFreqQuery(int[] arr) {
////        this.arr = arr;
//        occurrence = new HashMap<>();
//        // 顺序遍历数组初始化哈希表
//        for (int i = 0; i < arr.length; ++i) {
//            occurrence.putIfAbsent(arr[i], new ArrayList<>());
//            occurrence.get(arr[i]).add(i);
//        }
//    }
//
//    public int query(int left, int right, int value) {
//        List<Integer> pos = occurrence.getOrDefault(value, new ArrayList<>());
//        int l = lowerBound(pos, left);
//        int r = upperBound(pos, right);
//        return r - l;
//    }
//
//    private int lowerBound(List<Integer> pos, int target) {
//        int low = 0, high = pos.size() - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (pos.get(mid) < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return low;
//    }
//
//    private int upperBound(List<Integer> pos, int target) {
//        int low = 0, high = pos.size() - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (pos.get(mid) <= target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return low;
//    }
//
//
//    // error
//    public int query2(int left, int right, int value) {
//        int cnt = 0;
//        int mid = (right - left) / 2;
//        for (int i = left; i < mid; i++) {
//            if (arr[i] == value) {
//                cnt++;
//            }
//        }
//        for (int j = mid; j <= right; j++) {
//            if (arr[j] == value) {
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//
//
//    // 未AC timeout
//    public int query1(int left, int right, int value) {
//        int cnt = 0;
//        for (int i = left; i <= right; i++) {
//            if (arr[i] == value) {
//                cnt++;
//            }
//        }
//        return cnt;
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        int query = rangeFreqQuery.query(0, 11, 33);
        System.out.println(query);
    }

}
