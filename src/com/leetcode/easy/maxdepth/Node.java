package com.leetcode.easy.maxdepth;

import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/4/22 9:37
 * @instruction
 */
public class Node {

	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
