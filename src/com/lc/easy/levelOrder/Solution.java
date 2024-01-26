package com.lc.easy.levelOrder;

import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/6/5 9:01
 * @instruction
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class Solution {

	public static void main(String[] args) {

		Node n5 = new Node(5,null);
		Node n6 = new Node(6,null);
		List<Node> l3 = new ArrayList<>();
		l3.add(n5);
		l3.add(n6);

		Node n3 = new Node(3,l3);
		Node n2 = new Node(2,null);
		Node n4 = new Node(4,null);
		List<Node> l2 = new ArrayList<>();
		l2.add(n3);
		l2.add(n2);
		l2.add(n4);


		Node root = new Node(1,l2);
		levelOrder(root);
	}


	/**
	 *      1
	 *   3  2  4
	 * 5  6
	 *
	 * 输出
	 * [
	 *      [1],
	 *      [3,2,4],
	 *      [5,6]
	 * ]
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(Node root) {
//		List<List<Integer>> res = new ArrayList<>();
//		if(root==null){
//			return null;
//		}
//
//		Stack<Node> st = new Stack<>();
//		st.add(root);
//		while (!st.isEmpty()){
//			int size = st.size();
//			List<Integer> ll = new ArrayList<>();
//			for (int i = 0; i < size; i++) {
//				Node node = st.pop();
//				ll.add(node.val);
//				if(node.children!=null && node.children.size()>0){
//					for (Node child : node.children) {
//						st.add(child);
//					}
//				}
//			}
//			res.add(ll);
//		}
//		return res;

		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()){
			int size = que.size();
			List<Integer> layer = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = que.poll();
				layer.add(node.val);
				if(node.children!=null && node.children.size()>0){
					for(Node n:node.children){
						que.offer(n);
					}
				}
			}
			res.add(layer);
		}
		return res;
	}

}
