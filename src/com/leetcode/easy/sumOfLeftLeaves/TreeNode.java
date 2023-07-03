package com.leetcode.easy.sumOfLeftLeaves;

/**
 * @author zhai
 * @date 2021/5/18 下午6:22
 * @illustration
 * @slogan:
 * @version:
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
