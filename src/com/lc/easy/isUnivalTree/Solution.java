package com.lc.easy.isUnivalTree;

/**
 * @author zhaiyj
 * @date 2019/4/17 9:00
 * @instruction 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode l3 = new TreeNode(1, null, null);
		TreeNode r3 = new TreeNode(2, null, null);
		TreeNode l2 = new TreeNode(1, l3, r3);
		TreeNode r2 = new TreeNode(1, null, null);

		TreeNode root = new TreeNode(1, l2, r2);
		boolean flag = isUnivalTree(root);
		System.out.println(flag);
	}

	/**
	 * 输入：[1,1,1,1,1,null,1]
	 * 输出：true
	 * <p>
	 * 输入：[2,2,2,5,2]
	 * 输出：false
	 * <p>
	 * 给定树的节点数范围是 [1, 100]。
	 * 每个节点的值都是整数，范围为 [0, 99] 。
	 *
	 * @param root
	 * @return
	 */
	public static boolean isUnivalTree(TreeNode root) {
//		队列实现
//		if(root == null){
//			return true;
//		}
//		LinkedList<TreeNode> q = new LinkedList<>();
//		q.add(root);
//		while (!q.isEmpty()){
//			TreeNode node = q.poll();
//			if (node != null) {
//				if(node.val != root.val){
//					return false;
//				}
//				q.add(node.right);
//				q.add(node.left);
//			}
//		}
//		return true;

//      递归
//		if (root == null) {
//			return true;
//		}
//		if (root.left == null && root.right == null) {
//			return true;
//		}
//
//		if ((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val)) {
//			return false;
//		}else{
//			return isUnivalTree(root.left) && isUnivalTree(root.right);
//		}

//		递归实现
		if (root == null) {
			return true;
		}
//		return judge(root, root.val);
		return judge(root.left, root.val) && judge(root.right, root.val);

//		堆实现
//		if(root == null){
//			return true;
//		}
//		Stack<TreeNode> p = new Stack<>();
//		p.add(root);
//		while(!p.isEmpty()){
//			TreeNode node = p.pop();
//			if(node!=null){
//				if(node.val != root.val){
//					return false;
//				}
//				p.push(node.left);
//				p.push(node.right);
//			}
//		}
//		return true;
	}

	private static boolean judge(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		if (root.val != val) {
			return false;
		}
		return judge(root.left, root.val) && judge(root.right, root.val);
	}

}
