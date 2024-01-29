package com.lc.boxuegu.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhai
 * @date 2024/1/29 4:29 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 1, -1, -3, 6, 4, 5, 7, 10};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(nums, 4);
        for (List<Integer> list : lists) {
            list.forEach(o-> System.out.println(o + ","));
            System.out.println("---------------------");
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4] < target) {
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                int max = nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
                if (min > target || max < target) {
                    break;
                }

                int a = nums[i];
                int b = nums[j];
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int c = nums[m];
                    int d = nums[n];
                    if ((a + b + c + d) == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        res.add(list);
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        m++;
                        n--;
                    } else if ((a + b + c + d) < target) {
                        m++;
                    } else {
                        n--;
                    }
                }

            }
        }
        return res;
    }

}
