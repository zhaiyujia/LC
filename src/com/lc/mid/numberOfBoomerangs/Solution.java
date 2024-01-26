package com.lc.mid.numberOfBoomerangs;

import java.util.*;

/**
 * @author zhai
 * @date 2023/7/5 3:14 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {


    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {1, 0},
                {2, 0}
        };

        numberOfBoomerangs(points);
    }

    public int numberOfBoomerangs1(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Double, Integer> cntMap = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                double d = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);
            }
            for (Map.Entry<Double, Integer> entry : cntMap.entrySet()) {
                ans += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return ans;
    }

    public static int numberOfBoomerangs(int[][] points) {

        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    double dis = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                    if (!map.containsKey(dis)) {
                        map.put(dis, 1);
                    } else {
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1 + n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }

    public static double distance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
    }

}
