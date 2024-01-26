package com.lc.easy.increasingBST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/7/1 9:12
 * @instruction
 */
public class Solution {
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {

		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode eight = new TreeNode(8);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);


		five.left = three;
//		five.right = six;

		three.left = two;
//		three.right = four;

		two.left = one;
//
//		six.right = eight;
//		eight.left = seven;
//		eight.right = nine;
		increasingBST(five);

	}

	public static TreeNode increasingBST(TreeNode root) {

		return increasingBST(root,null);
//		infixOrderTree(root, list);
//		createNode(root, -1);
//		return root.right;
	}

	static TreeNode increasingBST(TreeNode root, TreeNode tail){
		if(root==null){
			return tail;
		}

		TreeNode res  = increasingBST(root.left, root);
		root.left = null;
		root.right = increasingBST(root.right, tail);
		return res;
	}



//	static void createNode(TreeNode root, int k){
//		if(k+1==list.size()){
//			return;
//		}
//		root.left = null;
//		TreeNode tmp = new TreeNode(list.get(k+1));
//		root.right = tmp;
//		root = root.right;
//		createNode(root, k+1);
//	}
//
//
//	// 中序遍历 5 3 6
//	public static List<Integer> infixOrderTree(TreeNode node, List list) {
//		if (node.left != null) {
//			infixOrderTree(node.left, list);
//		}
//		list.add(node.val);
//		if (node.right != null) {
//			infixOrderTree(node.right, list);
//		}
//		return list;
//	}


}
