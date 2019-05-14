package com.leetcode.maxdepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhaiyj
 * @date 2019/4/2 9:07
 * @instruction
 */
public class MaxDepth {

	public static void main(String[] args) {
		TreeNode l3 = new TreeNode(15, null, null);
		TreeNode r3 = new TreeNode(7, null, null);
		TreeNode rr2 = new TreeNode(20, l3, r3);
		TreeNode ll2 = new TreeNode(9, null, null);
		TreeNode root = new TreeNode(3, ll2, rr2);
		int x = maxDepth(root);
		System.out.println(x);
	}

	public static int maxDepth(TreeNode root) {
		if (root==null){
			return 0;
		}
		int res = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()){
			++res;
			for (int i = q.size(); i > 0; --i) {
				TreeNode t = q.poll();
				if(t.right !=null){
					q.offer(t.right);
				}
				if (t.left!=null){
					q.offer(t.left);
				}
			}
		}
		return res;
	}

}
