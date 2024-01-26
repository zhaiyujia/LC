package com.lc.easy.invertTree;

/**
 * @author zhaiyj
 * @date 2019/4/1 9:06
 * @instruction
 *
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
