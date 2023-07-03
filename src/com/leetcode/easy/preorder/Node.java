package com.leetcode.easy.preorder;

import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/4/11 9:15
 * @instruction
 */
public class Node {

	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}

}
