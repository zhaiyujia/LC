package com.lc.easy.averageOfLevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhaiyj
 * @date 2019/6/26 9:04
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {


//		TreeNode fifteen = new TreeNode(15);
//		TreeNode serven = new TreeNode(7);
//		TreeNode nine = new TreeNode(9);
//		TreeNode twenty = new TreeNode(20);
//
//		TreeNode root = new TreeNode(3);
//		root.left = nine;
//		root.right = twenty;
//
//		twenty.left = fifteen;
//		twenty.right = serven;



		TreeNode root = new TreeNode(2147483647);
		TreeNode root1 = new TreeNode(2147483647);
		TreeNode root2 = new TreeNode(2147483647);
		root.left = root1;
		root.right = root2;
		averageOfLevels(root);


	}


	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();

		if(root.left==null && root.right==null){
			 result.add((double) root.val);
			 return result;
		}


		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum = sum + node.val;
				if(node.right!=null){
					queue.add(node.right);
				}
				if(node.left!=null){
					queue.add(node.left);
				}
			}
			double calut  = sum * 1.0d /size;
			result.add(calut);
		}
		return result;
	}
}
