package com.lc.boxuegu.moveZeroes;

/**
 * @author zhai
 * @date 2024/1/19 9:53 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{2, 1};
        solution.moveZeroes3_2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes1_1(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }


    public void moveZeroes1_2(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public void moveZeroes2_1(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public void moveZeroes2_2(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }


    public void moveZeroes2_3(int[] nums) {
        int i = 0;
        int k = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
    }

    public void moveZeroes3_1(int[] nums) {
        int i = 0;
        int k = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }

        }
//        while (l < r && r < nums.length) {
//            if (nums[l] == 0 && nums[r] != 0) {
//                int temp = nums[r];
//                nums[r] = nums[l];
//                nums[l] = temp;
//                l++;
//            }
//            if (nums[r] == 0) {
//                r++;
//            }
//        }
    }

    public void moveZeroes3_2(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
