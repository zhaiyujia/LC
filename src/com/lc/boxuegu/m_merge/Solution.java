package com.lc.boxuegu.m_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2025/4/27 20:45
 */
public class Solution {


    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        Solution solution = new Solution();
        solution.merge(intervals);
    }

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                return p[0] - q[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for(int[] p : intervals){
            int m = ans.size();
            if(m > 0 && p[0] <= ans.get(m - 1)[1]){
                ans.get(m - 1)[1]  = Math.max(ans.get(m - 1)[1], p[1]);
            }else{
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

//
//    public int[][] merge1(int[][] intervals) {
//        int[][] result = new int[intervals.length][2];
//        int index = 0;
//        int[] child = new int[2];
//        for (int i = 0; i < intervals.length; i++) {
//            child = intervals[i];
//            int[] ints = result[index];
//            if (ints.length > 0 && ints[0] >= 0) {
//                child = ints;
//            }
//            int[] next = intervals[i + 1];
//            if (child[1] > next[0]) {
//                // 可以合成新的数组
//                //[chilid[0], next[1]
//                int[] nc = new int[2];
//                nc[0] = child[0];
//                nc[1] = next[1];
//                result[index] = nc;
//            } else {
//                // child[0], child[1]
//                index++;
//            }
//        }
//        return result;
//    }


}
