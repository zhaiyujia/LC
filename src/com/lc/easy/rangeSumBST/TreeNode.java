package com.lc.easy.rangeSumBST;

/**
 * @author zhaiyj
 * @date 2019/4/16 9:04
 * @instruction
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
