package com.lc.lingGod.S_maxDepth;

/**
 * @author zhaiyj
 * @date 2025/5/21 21:07
 */
public class Solution {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        f(root, 0);
        return ans;
    }

    public void f(TreeNode node, int cnt){
        if (node == null){
            return;
        }

        cnt++;
        ans = Math.min(cnt, ans);
        f(node.left, cnt);
        f(node.right, cnt);
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth1(root.left);
        int r = maxDepth1(root.right);
        return Math.max(l, r) + 1;
    }

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


}
