package com.lc.interview.a.removeElement;

/**
 * @author zhai
 * @date 2023/10/25 4:15 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        System.out.println("--------");
        t2();
        System.out.println("--------");
        t3();
    }

    private static void t1() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
//        int i = removeElement(nums, val);
        int i = removeElementV3(nums, val);
        System.out.println("t1-result:" + i);
        for (int num : nums) {
            System.out.println("t1:" + num);
        }
    }

    private static void t2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
//        int i = removeElement(nums, val);
        int i = removeElementV3(nums, val);
        System.out.println("t2-result:" + i);
        for (int num : nums) {
            System.out.println("t2:" + num);
        }
    }

    private static void t3() {
        int[] nums = new int[]{2};
        int val = 3;
//        int i = removeElement(nums, val);
        int i = removeElementV3(nums, val);
        System.out.println("t3-result:" + i);
        for (int num : nums) {
            System.out.println("t3:" + num);
        }
    }


    public static int removeElementV1(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                index++;
                continue;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        j = j + 1;
                        index++;
                        break;
                    }
                }
            }
        }
        return index;
    }


    public static int removeElementV2(int[] nums, int val) {
        // 0, 1, 2, 2, 3, 0, 4, 2
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElementV3(int[] nums, int val) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < nums.length && p1 <= p2) {
            if (nums[p1] == val) {
                nums[p1] = nums[p2];
                p2--;
            } else {
                p1++;
            }
        }
        return p1;
    }

    public static int removeElementV4(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if(nums[left] == val){
                nums[left] = nums[right-1];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }


    public static int removeElement(int[] nums, int val) {
        int p1 = nums.length - 1;
        int p2 = 0;
        int index = 0;
        while (p1 >= 0 && p1 >= p2) {
            int num = nums[p1];
            if (num != val) {
                // 跟第一个位置换位置
                int temp = nums[p2];
                nums[p2] = num;
                nums[p1] = temp;
                index++;
                p2++;
            } else {
                p1--;
            }
        }
        return index;
    }

}
