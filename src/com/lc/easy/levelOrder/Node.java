package com.lc.easy.levelOrder;

import java.util.List;

/**
 * @author zhaiyj
 * @date 2019/6/5 9:02
 * @instruction
 */
public class Node {

	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}

}
