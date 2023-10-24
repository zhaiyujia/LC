package com.leetcode.mid.threeSum;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author zhai
 * @date 2023/7/14 10:51 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0};
//        int[] nums = {0, 1, 1};
        int[] nums = {4, -9, -13, -9, 0, -12, 12, -14, 12, 1, 3, 5, 5, 8, 2, -2, 8, 1, 2, -6, -6, 1, 6, -15, -2, 7, -11, 3, -2, 1, 11, 10, 8, 14, 8, -15, 9, 5, -14, 6, 14, -3, -12, 4, -10, 5, -12, 13, 14, -3, -15, -7, 5, -2, -15, 10, -10, 11, -2, -5, -2, -5, -10, 13, -14, 14, 13, 2, 4, 7, -6, 3, 11, -3, -15, -14, 10, 10, 6, 1, -8, -2, 1, 12, 11, 1, 7, 8, -10, 13, -11, 3, -15, -6, -7, 8, -7, 13, -5, 5, -3, 4, -15, -7, 9, -15, -14, -4, 2, 0, 4, 9, 13, -10, -2, 10};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(JSONObject.toJSONString(lists));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        // 排个序，然后做预处理，处理过的不进行数据填充
                        if (sum == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                        }
                    }
                }
            }
        }

        Set<String> exists = new HashSet<>();

        List<List<Integer>> rs = new ArrayList<>();
        for (List<Integer> list : result) {
            Integer x = list.get(0);
            Integer y = list.get(1);
            Integer z = list.get(2);
            int mid = 0;
            int min = Math.min(Math.min(x, y), z);
            int max = Math.max(Math.max(x, y), z);
            if (x != min && x != max) {
                mid = x;
            } else if (y != min && y != max) {
                mid = y;
            } else if (z != min && z != max) {
                mid = z;
            }
            String str = "" + min + mid + max;
            if (exists.contains(str)) {
                continue;
            }
            exists.add(str);
            rs.add(list);
        }

        return rs;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> exists = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        // 排个序，然后做预处理，处理过的不进行数据填充
                        int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                        int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                        int mid = 0;
                        if (nums[i] != min && nums[i] != max) {
                            mid = nums[i];
                        } else if (nums[j] != min && nums[j] != max) {
                            mid = nums[j];
                        } else if (nums[k] != min && nums[k] != max) {
                            mid = nums[k];
                        }
                        String str = "" + min + mid + max;
                        if (exists.contains(str)) {
                            continue;
                        }

                        if (sum == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                            exists.add(str);
                        }
                    }
                }
            }
        }

        return result;
    }

}
