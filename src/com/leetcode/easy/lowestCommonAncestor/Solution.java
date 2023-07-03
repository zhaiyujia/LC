package com.leetcode.easy.lowestCommonAncestor;

/**
 * @author zhaiyj
 * @date 2019/6/20 9:00
 * @instruction
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *                                     6
 *                                2            8
 *                            0      4      7     9
 *                                3    5
 */
public class Solution {


	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		TreeNode zero = new TreeNode(0);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode seven = new TreeNode(7);

		root.left=two;
		root.right = eight;

		two.left = zero;
		two.right = four;


		four.left = three;
		four.right = five;

		eight.left = seven;
		eight.right = nine;

		TreeNode node = lowestCommonAncestor(root,two,eight);
		System.out.println(node.val);
	}

	/*
	输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	输出: 6
	解释: 节点 2 和节点 8 的最近公共祖先是 6。

	输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	输出: 2
	解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if((root.val - p.val) * (root.val-q.val)<=0){
			return root;
		}else if(root.val<p.val && root.val<q.val){
			return lowestCommonAncestor(root.right, p, q);
		}else {
			return lowestCommonAncestor(root.left, p, q);
		}
	}
}
