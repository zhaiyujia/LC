package com.leetcode.maxdepth;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhaiyj
 * @date 2019/4/22 9:38
 * @instruction
 */
public class Solution {

	public static void main(String[] args) {
//		Node l3 = new Node(5, Lists.newArrayList());
//		Node r3 = new Node(6, Lists.newArrayList());
//
//		Node l2 = new Node(3, Lists.newArrayList(l3, r3));
//		Node z2 = new Node(2, Lists.newArrayList());
//		Node r2 = new Node(4, Lists.newArrayList());
//
//		Node root = new Node(1, Lists.newArrayList(l2, z2, r2));

		Node l3 = new Node(5, Lists.newArrayList());
		Node r3 = new Node(0, Lists.newArrayList());


		Node r33 = new Node(6, Lists.newArrayList());

		Node l2 = new Node(10, Lists.newArrayList(l3, r3));
		Node r2 = new Node(3, Lists.newArrayList(r33));

		Node root = new Node(1, Lists.newArrayList(l2, r2));


		int result = maxDepth(root);
		System.out.println(result);
	}

	public static int maxDepth(Node root) {
//		if (root == null) {
//			return 0;
//		}
//		int depth = 0;
//		for (int i = 0; i < root.children.size(); i++) {
//			depth = Math.max(depth, maxDepth(root.children.get(i)));
//		}
//		return depth + 1;

		int res = 0;
		if (root == null) {
			return res;
		}

		Stack<Node> q = new Stack<>();
		q.add(root);
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; --i) {
				Node node = q.pop();
				if (node.children != null) {
					for (Node child : node.children) {
						q.add(child);
					}
				}
			}
			++res;
		}
		return res;

//		int res = 0;
//		if (root == null) {
//			return 0;
//		}
//
//		Queue<Node> q = new LinkedList<>();
//		q.add(root);
//		while (!q.isEmpty()) {
//			for (int i = q.size(); i > 0; --i) {
//				Node node = q.poll();
//				if (node.children != null) {
//					for (Node child : node.children) {
//						q.add(child);
//					}
//				}
//			}
//			++res;
//		}
//		return res;

//		int res = 0;
//		if (root == null) {
//			return res;
//		}
//		Stack<Node> q = new Stack<>();
//		q.add(root);
//		res++;
//		while (!q.isEmpty()) {
//			Node node = q.pop();
//			if (node.children != null) {
//				for (int i = 0; i < node.children.size(); i++) {
//					q.add(node.children.get(i));
//				}
//				++res;
//			}
//		}
//		return res;
	}

}
