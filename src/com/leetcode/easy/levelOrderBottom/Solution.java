package com.leetcode.easy.levelOrderBottom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/6/14 8:48
 * @instruction
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 给定二叉树 [3,9,20,null,null,15,7],
 * [[15,7],[9,20],[3]]
 */
public class Solution {

	public static void main(String[] args) {

		TreeNode r1 = new TreeNode(15);
		TreeNode r2 = new TreeNode(7);

		TreeNode r3 = new TreeNode(20);
		r3.left = r1;
		r3.right = r2;

		TreeNode r4 = new TreeNode(9);
		TreeNode root = new TreeNode(3);

		root.right = r3;
		root.left = r4;

		levelOrderBottom(root);

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		func(lists, 0, root);
		for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
			List<Integer> temp = lists.get(i);
			lists.set(i, lists.get(j));
			lists.set(j, temp);
		}
		return lists;
	}


	private static void func(List<List<Integer>> lists, int level, TreeNode root) {
		if (root == null) {
			return;
		}
		if (lists.size() == level) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			lists.add(list);
		} else {
			lists.get(level).add(root.val);
		}
		func(lists, level + 1, root.left);
		func(lists, level + 1, root.right);
	}


//	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//
//		if(root==null){
//			return new ArrayList<List<Integer>>();
//		}
//
//		List<List<Integer>> result = new ArrayList<>();
//		Queue<TreeNode> queue = new LinkedList<>();
//		Queue<TreeNode> q = null;
//		queue.add(root);
//		while (!queue.isEmpty()){
//			q = new LinkedList<>();
//			List<Integer> list = new ArrayList<>();
//			int size = queue.size();
//			for (int i = 0; i < size; i++) {
//				TreeNode node = queue.poll();
//				list.add(node.val);
//				if(node.left!=null){
//					q.offer(node.left);
//				}
//				if(node.right!=null){
//					q.offer(node.right);
//				}
//			}
//			result.add(0,list);
//			queue = q;
//		}
//		return result;
//	}
}
