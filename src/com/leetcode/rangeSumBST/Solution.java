package com.leetcode.rangeSumBST;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/5/22 9:06
 * @instruction
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root11 = new TreeNode(3,null,null);
		TreeNode root22 = new TreeNode(7,null,null);
		TreeNode root23 = new TreeNode(18,root22,null);


		TreeNode root1 = new TreeNode(5,root11,null);
		TreeNode root2 = new TreeNode(15,root23,null);

		TreeNode root = new TreeNode(10,root1,root2);
		int result = rangeSumBST(root,7,15);
		System.out.println(result);
	}

	/**
	 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
	 * 输出：32
	 *
	 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	 * 输出：23
	 *
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public static int rangeSumBST(TreeNode root, int L, int R) {
		if(root==null){
			return 0;
		}

		if(root.val>R){
			return rangeSumBST(root.left, L, R);
		}else if(root.val<L){
			return rangeSumBST(root.right, L, R);
		}else{
			return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
		}

//		int result = 0;
//		LinkedList<TreeNode> stack = new LinkedList<>();
//		stack.add(root);
//		while (!stack.isEmpty()){
//			TreeNode node = stack.pop();
//			int val = node.val;
//			if(val>= L && val <= R){
//				result = result + val;
//			}
//			if(node.left!=null){
//				stack.add(node.left);
//			}
//			if(node.right!=null){
//				stack.add(node.right);
//			}
//		}
//		return result;
//		Stack<TreeNode> stack = new Stack<>();
//		stack.add(root);
//		while (!stack.isEmpty()){
//			TreeNode node = stack.pop();
//			int val = node.val;
//			if(val>= L && val <= R){
//				result = result + val;
//			}
//			if(node.left!=null){
//				stack.add(node.left);
//			}
//			if(node.right!=null){
//				stack.add(node.right);
//			}
//		}
//		return result;
	}

}
