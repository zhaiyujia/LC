package com.leetcode.easy.binaryTreePaths;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/6/27 8:50
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);


		root.left = two;
		root.right = three;
		two.right = five;

		List<String> list = binaryTreePaths(root);
		System.out.println(list);


	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new LinkedList<>();
		if (root == null) {
			return list;
		}
		run(root, "", list);
		return list;
	}

	private static void run(TreeNode node, String str, List<String> list) {
		if (node.left == null && node.right == null) {
			str += node.val;
			list.add(str);
			return;
		}
		str += (node.val + "->");
		if (node.left != null) {
			run(node.left, str, list);
		}
		if (node.right != null) {
			run(node.right, str, list);
		}

	}


}
