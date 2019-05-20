package com.leetcode.sortedArrayToBST;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/5/16 8:55
 * @instruction 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{-3, 0, 5};
		sortedArrayToBST(nums);
	}

	/**
	 * 给定有序数组: [-10,-3,0,5,9],
	 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	 *
	 * @param nums
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = bulid(nums, 0, nums.length - 1);
		return root;
//		if (nums==null || nums.length==0){
//			return null;
//		}
//
//		if(nums.length==1){
//			return  new TreeNode(nums[0]);
//		}
//
//		int x = 0;
//		int count = nums.length-1;
//		if(nums.length%2==0){
//			x = nums.length / 2 -1;
//		}else{
//			x = nums.length / 2;
//		}
//
//
//		TreeNode node = new TreeNode(nums[x]);
//		List<TreeNode> nodeList = new LinkedList<TreeNode>();
//		for (int i = 0; i < nums.length; i++) {
//			nodeList.add(new TreeNode(nums[i]));
//		}
//
//		for(int i=x-1;i>0;i--){
//			nodeList.get(i).left = nodeList.get(i-1);
//		}
//		for (int i = nums.length-1; i > x; i--) {
//			nodeList.get(i).right = nodeList.get(i-1);
//		}
//		node.left = nodeList.get(x-1);
//		node.right = nodeList.get(count);
//
//		return node;
	}

	public static TreeNode bulid(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = (end + start) / 2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = bulid(nums, start, mid - 1);
			root.right = bulid(nums, mid + 1, end);
			return root;
		}
	}
}
