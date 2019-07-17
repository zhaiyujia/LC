package com.leetcode.trimBST;

/**
 * @author zhaiyj
 * @date 2019/7/17 8:51
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        three.left = zero;
        three.right = four;

        zero.right = two;

        two.left = one;



        TreeNode treeNode = trimBST(three, 1, 4);

        System.out.println(treeNode);
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }else if(root.val<L){
            return trimBST(root.right, L, R);
        }else if(root.val>R){
            return trimBST(root.left, L, R);
        }else{
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }



}
