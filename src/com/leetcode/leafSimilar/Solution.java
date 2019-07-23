package com.leetcode.leafSimilar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/7/23 9:04
 * @description
 */
public class Solution {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);

        three.left = five;
        three.right = one;

        five.left = six;
        five.right = two;

        two.left = seven;
        two.right = four;

        one.left = nine;
        one.right = eight;


        leafSimilar(three, three);


    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        BFS(root1, list1);
        BFS(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public static void BFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            if(root.left==null&&root.right==null){
                list.add(root.val);
            }
            BFS(root.left, list);
            BFS(root.right, list);
        }
    }


}
