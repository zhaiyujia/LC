package com.lc.boxuegu.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhai
 * @date 2024/1/22 7:22 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        solution.threeSum2(nums);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 先进行排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1;// 左指针
            int k = nums.length - 1; // 右指针

            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                if ((a + b + c) == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    res.add(list);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if ((a + b + c < 0)) {
                    j++;
                } else {
                    k--;
                }

            }

        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
