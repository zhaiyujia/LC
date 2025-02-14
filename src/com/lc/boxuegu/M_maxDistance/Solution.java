package com.lc.boxuegu.M_maxDistance;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] position = new int[]{5,4,3,2,1,1000000000};
        Solution solution = new Solution();
        int i = solution.maxDistance(position, 2);
        System.out.println(i);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int[] position, int m) {
        int pre = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i]  - pre >= mid) {
                pre = position[i];
                cnt++;
            }
        }
        return  cnt >= m;
    }
}
