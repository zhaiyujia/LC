package com.lc.easy.searchBST;

/**
 * @author zhaiyj
 * @date 2019/4/16 9:04
 * @instruction
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 *
 */
public class Solution {


	public static void main(String[] args) {
		TreeNode l3 = new TreeNode(1,null,null);
		TreeNode r3 = new TreeNode(3,null,null);
		TreeNode l2 = new TreeNode(2,l3,r3);
		TreeNode r2 = new TreeNode(7,null,null);

		TreeNode root = new TreeNode(4,l2,r2);
		TreeNode result = searchBST(root,2);
		System.out.println(result);
	}

	/**
	 * 给定二叉搜索树:

	     4
	    / \
	   2   7
	  / \
	 1   3

	 和值: 2

	 你应该返回如下子树:

	   2
	  / \
	 1   3
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode searchBST(TreeNode root, int val) {

		if(root == null){
			return null;
		}
		TreeNode node = root;
		while (node!=null){
			if(node.val > val){
				node = node.left;
			}else if(node.val < val){
				node = node.right;
			}else{
				return node;
			}
		}
		return null;

//		if(root == null){
//			return null;
//		}
//		if(root.val < val){
//			return searchBST(root.right, val);
//		}else if(root.val > val){
//			return searchBST(root.left, val);
//		}
//		return root;


//		if(root != null){
//			Stack<TreeNode> p = new Stack<>();
//			p.add(root);
//			while(!p.isEmpty()){
//				TreeNode node = p.pop();
//				if(node.val == val){
//					return node;
//				}
//				if(node.left != null){
//					p.add(node.left);
//				}
//				if(node.right != null){
//					p.add(node.right);
//				}
//			}
//		}
//		return null;
	}

}
