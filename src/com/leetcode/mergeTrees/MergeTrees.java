package com.leetcode.mergeTrees;

/**
 * @author zhaiyj
 * @date 2019/4/1 9:05
 * @instruction
 */
public class MergeTrees {

	public static void main(String[] args) {

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		TreeNode root = new TreeNode((t1 == null ? 0:t1.val) + (t2 == null ? 0:t2.val));
		root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
		return root;
	}
}
