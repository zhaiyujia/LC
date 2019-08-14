package com.dp.minimumTotal;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/8/13 9:01
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> o = new ArrayList<>();
        o.add(2);

        List<Integer> t = new ArrayList<>();
        t.add(3);
        t.add(4);

        List<Integer> tr = new ArrayList<>();
        tr.add(6);
        tr.add(5);
        tr.add(7);


        List<Integer> fo = new ArrayList<>();
        fo.add(4);
        fo.add(1);
        fo.add(8);
        fo.add(3);


        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(o);
        triangle.add(t);
        triangle.add(tr);
        triangle.add(fo);
        minimumTotal(triangle);

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row < 1) {
            return 0;
        }

        int[] dp = new int[row];
        for (int i = 0; i < row; i++) {
            dp[i] = triangle.get(row-1).get(i);
        }

        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

//        int indoorMin = 0;
//        for (int i = 0; i < triangle.size(); i++) {
//            List<Integer> indoorList = triangle.get(i);
//            if (indoorList.size() == 1) {
//                indoorMin = indoorList.get(0);
//            } else {
//                int[] d = {Integer.MAX_VALUE};
//                for (int j = 0; j < indoorList.size() - 1; j++) {
//                    int temp = Math.min(indoorList.get(j), indoorList.get(j + 1));
//                    if (temp < d[0]) {
//                        d[0] = temp;
//                    }
//                }
//                indoorMin += d[0];
//            }
//        }
//        return indoorMin;
    }

}

