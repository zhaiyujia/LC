package com.medium.generateTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/7/10 8:54
 * @description 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 二叉搜索树的特点， 左 > 根 > 右
 */
public class Solution {

    public static void main(String[] args) {
        int n = 3;
        generateTrees(n);
    }


    public static List<TreeNode> generateTrees(int n) {

        List<TreeNode>[] res = new ArrayList[n + 1];
        res[0] = new ArrayList<>();
        if (n == 0) {
            return res[0];
        }

        res[0].add(null);
        for (int len = 1; len <= n; len++) {
            res[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                for(TreeNode leftNode:res[left]){
                    for (TreeNode rightNode:res[right]){
                        TreeNode treeNode = new TreeNode(root);
                        treeNode.left = leftNode;
                        treeNode.right = clone(rightNode,root);
                        res[len].add(treeNode);
                    }
                }
            }
        }
        return res[n];


//        if (n == 0) {
//            return new ArrayList<TreeNode>();
//        }
//        List<TreeNode> res =  helper(1, n);
//        return res;
    }

    private static TreeNode clone(TreeNode n, int offset){
        if(n==null){
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    public static List<TreeNode> helper(int begin, int end) {

        List<TreeNode> res = new ArrayList<>();
        if (begin > end) {
            res.add(null);
            return res;
        }

        for (int i = begin; i <= end; ++i) {
            List<TreeNode> left = helper(begin, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }


}
