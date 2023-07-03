package com.leetcode.easy.sumOfLeftLeaves;

import java.util.Stack;

/**
 * @author zhai
 * @date 2021/5/18 下午6:22
 * @illustration
 * @slogan:
 * @version:
 * 计算给定二叉树的所有左叶子之和。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Solution {

    public static void main(String[] args) {


        TreeNode z1 = new TreeNode(15, null, null);
        TreeNode z2 = new TreeNode(7, null, null);
        TreeNode z3 = new TreeNode(20, z1, z2);
        TreeNode z7 = new TreeNode(10, null, null);
        TreeNode z4 = new TreeNode(9, z7, null);
        TreeNode z5 = new TreeNode(3, z4, z3);
        int i = sumOfLeftLeaves(z5);
        System.out.println(i);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null){
            return 0;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode pop = st.pop();
            if(pop.left != null){
                sum+=pop.left.val;
                st.push(pop.left);
            }
            if(pop.right != null){
                st.push(pop.right);
            }
        }
        return sum;
    }

}
