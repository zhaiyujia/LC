package com.leetcode.easy.distributeCandies;

/**
 * @author zhaiyj
 * @date 2019/11/22 9:10 上午
 */
public class Solution1 {

    public static void main(String[] args) {

        int candies = 7;
        int num_people = 4;
        distributeCandies(candies,num_people);

    }

    public static int[] distributeCandies(int candies, int num_people) {
        int curr_give = 0;
        int[]res = new int[num_people];
        while (candies >0){
            res[curr_give % num_people] += Math.min(++curr_give,candies);
            candies -= curr_give;
        }
        return res;
    }



//    public static int[] distributeCandies(int candies, int num_people) {
//        int[] ans = new int[num_people];
//        int index = 0;
//        int counts = 1;
//        while (candies - counts >=0){
//            ans[index++%num_people] += counts;
//            candies -= counts++;
//        }
//        ans[index%num_people] +=candies;
//        return ans;
//    }
}
