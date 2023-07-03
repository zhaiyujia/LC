package com.leetcode.easy.nextGreaterElement;

/**
 * @author zhaiyj
 * @date 2019/7/19 8:56
 * @description 给定两个没有重复元素的数组 nums1 和 nums2 ，
 * 其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 
 * 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 
 * 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 */
public class Solution {

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        int[] res = nextGreaterElement(num1, num2);
        System.out.println(res);
    }

    public static int findId(int[] nums, int a){
        int len = nums.length;
        int i = 0;
        for(i = 0; i<len; i++){
            if(nums[i] == a) break;
        }
        return i;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i=0; i<len1; i++){
            int a = findId(nums2,nums1[i]) + 1;
            int j = a;
            for(;j<len2; j++){
                if(nums2[j] > nums1[i]) break;
            }
            if(j < len2) nums1[i] = nums2[j];
            else nums1[i] = -1;
        }
        return nums1;


//        int[] result = new int[nums1.length];
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (int i = 0; i < nums2.length - 1; i++) {
//            int k = i + 1;
//            while (k < nums2.length) {
//                if (nums2[i] < nums2[k]) {
//                    hm.put(nums2[i], nums2[k]);
//                    k = nums2.length;
//                } else {
//                    k++;
//                }
//            }
//        }
//        for (int j = 0; j < nums1.length; j++) {
//            result[j] = hm.getOrDefault(nums1[j], -1);
//        }
//        return result;


//        int[] result = new int[nums1.length];
//        Stack<Integer> s = new Stack<>();
//        HashMap<Integer,Integer> hasMap = new HashMap<>();
//
//        for (int num : nums2) {
//            while (!s.isEmpty() && s.peek()<num){
//                hasMap.put(s.pop(),num);
//            }
//            s.push(num);
//        }
//
//        for (int i = 0; i < nums1.length; i++) {
//            result[i] = hasMap.getOrDefault(nums1[i],-1);
//        }
//        return result;


//        int[] result = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            int o = nums1[i];
//            int index = 0;
//            int temp = -1;
//            for (int j = 0; j < nums2.length; j++) {
//                if(nums2[j]==o){
//                    index = j;
//                    temp = index;
//                    j = temp;
//                }
//                if(temp>-1){
//                    if(nums2[j]>o){
//                        result[i] = nums2[j];
//                        break;
//                    }else{
//                        result[i] = -1;
//                        continue;
//                    }
//                }
//            }
//
//        }
//        return result;
    }


}
