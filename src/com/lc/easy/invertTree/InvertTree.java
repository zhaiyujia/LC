package com.lc.easy.invertTree;

/**
 * @author zhaiyj
 * @date 2019/4/4 9:06
 * @instruction
 * 翻转一棵二叉树。
 */
public class InvertTree {


	public static void main(String[] args) {
//		TreeNode thirdLeft = new TreeNode(1,null,null);
//		TreeNode thirdright = new TreeNode(3,null,null);
//		TreeNode twoLeft = new TreeNode(2,thirdLeft,thirdright);
//
//
//		TreeNode thirdLeft1 = new TreeNode(6,null,null);
//		TreeNode thirdright1 = new TreeNode(9,null,null);
//		TreeNode twoRight = new TreeNode(7,thirdLeft1,thirdright1);


		TreeNode root = new TreeNode(4,null,null);
		TreeNode result = invertTree(root);
		System.out.println(result);
	}

	/**
	 *  输入
	 *      4
	      /   \
	     2     7
	    / \   / \
	   1   3 6   9

	 * 输出
	 *      4
	      /   \
	     7     2
	    / \   / \
	   9   6 3   1
	 * @param root
	 * @return
	 */

	public static TreeNode invertTree(TreeNode root) {

		if(root==null){
			return null;
		}

		if((root.left == null) && (root.right == null)){
			return root;
		}

		TreeNode temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

}
