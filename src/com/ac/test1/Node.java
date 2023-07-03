package com.ac.test1;

import java.util.*;

/**
 * @author zhai
 * @date 2022/4/27 11:02 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Node {
    private Map<Character, Node> map;   //用于放这个Node的所有子节点，储存形式是：Map(char, Node)
    private List<String> PattenStrings; //该节点处包含的所有pattern string
    private Node failure;               //fail指针指向的node
    private Boolean isRoot = false;     //是否为根结点


    public Node() {
        map = new HashMap<>();
        PattenStrings = new ArrayList<>();
    }


    public Node(Boolean isRoot) {
        this();
        this.isRoot = isRoot;
    }


    //用于build trie，如果一个字符character存在于子节点中，不做任何操作，返回这个节点的node
    //否则，建一个node，并将map(char,node)添加到当前节点的子节点里，并返回这个node
    public Node insert(Character character) {
        Node node = this.map.get(character);
        if (node == null) {
            node = new Node();
            map.put(character, node);
        }
        return node;
    }


    public void addPattenString(String keyword) {
        PattenStrings.add(keyword);
    }


    public void addPattenString(Collection<String> keywords) {
        PattenStrings.addAll(keywords);
    }


    public Node find(Character character) {
        return map.get(character);
    }


    /**
     * 利用父节点fail node来寻找子节点的fail node
     * or
     * parseText时找下一个匹配的node
     */
    public Node nextState(Character transition) {
        //用于构建fail node时，这里的this是父节点的fail node
        //首先从父节点的fail node的子节点里找有没有值和当前失败节点的char值相同的
        Node state = this.find(transition);

        //如果找到了这样的节点，那么该节点就是当前失败位置节点的fail node
        if (state != null) {
            return state;
        }

        //如果没有找到这样的节点，而父节点的fail node又是root，那么返回root作为当前失败位置节点的fail node
        if (this.isRoot) {
            return this;
        }

        //如果上述两种情况都不满足，那么就对父节点的fail node的fail node再重复上述过程，直到找到为止
        //这个地方借鉴了KMP算法里面求解next列表的思想
        return this.failure.nextState(transition);
    }


    public Collection<Node> children() {
        return this.map.values();
    }


    public void setFailure(Node node) {
        failure = node;
    }


    public Node getFailure() {
        return failure;
    }


    //返回一个Node的所有子节点的键值，也就是这个子节点上储存的char
    public Set<Character> getTransitions() {
        return map.keySet();
    }


    public Collection<String> PattenString() {
        return this.PattenStrings == null ? Collections.<String>emptyList() : this.PattenStrings;
    }
}
