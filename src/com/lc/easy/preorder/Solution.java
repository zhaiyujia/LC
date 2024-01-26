package com.lc.easy.preorder;


import java.util.*;

/**
 * @author zhaiyj
 * @date 2019/4/11 9:14
 * @instruction 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 *      1
 *   3  2  4
 * 5  6
 */
public class Solution {

	public static void main(String[] args) {

		Node r3 = new Node(5, null);
		Node l3 = new Node(6, null);
		List<Node> three = new ArrayList<>();
		three.add(r3);
		three.add(l3);
		Node r21 = new Node(3, three);
		Node r22 = new Node(2, null);
		Node r23 = new Node(4, null);

		List<Node> two = new ArrayList<>();
		two.add(r21);
		two.add(r22);
		two.add(r23);

		Node root = new Node(1, two);
//		List<Integer> list = preorder(root);
		List<Integer> list = endPostorder(root);
		System.out.println(list.toString());

	}

	/**
	 * 返回其后序遍历: [5,6,3,2,4,1].
	 * @param root
	 * @return
	 */
	public static List<Integer> endPostorder(Node root) {
		List<Integer> result = new ArrayList<>();

//		if(root!=null){
//			Stack<Node> q = new Stack<>();
//			q.add(root);
//			while(!q.isEmpty()){
//				Node node = q.pop();
//				result.add(node.val);
//				if(node.children!=null){
//					q.addAll(node.children);
//				}
//			}
//		}
//		Collections.reverse(result);
//		return result;

		// 递归
		if(root!=null){
			if(root.children!=null){
				root.children.forEach(node->{
					result.addAll(endPostorder(node));
				});
			}
			result.add(root.val);
		}
		return result;
	}


	/**
	 * 返回其前序遍历: [1,3,5,6,2,4]。
	 *
	 * @param root
	 * @return
	 */
	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();

		if(root != null){

			LinkedList<Node> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()){
				Node node = q.poll();
				result.add(node.val);
				if(node.children!=null){
					q.addAll(0,node.children);
				}
			}
		}


//		if (root != null) {
//			Stack<Node> q = new Stack<>();
//			q.add(root);
//			while (!q.isEmpty()) {
//				Node node = q.pop();
//				result.add(node.val);
//				if(node.children != null){
//					for (int i = node.children.size() -1 ; i >=0; i--) {
//						q.add(node.children.get(i));
//					}
//				}
//			}
//		}
		return result;
	}

}
