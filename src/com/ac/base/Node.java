package com.ac.base;

import java.util.*;

/**
 * @author zhai
 * @date 2022/4/28 10:26 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Node {

    /**
     * 根节点
     */
    private boolean root = false;

    /**
     * 该节点下的所有节点
     */
    private Map<Character, Node> childNodes;

    /**
     * 失败指向节点
     */
    private Node failure;

    /**
     * 该节点下匹配的word
     */
    private List<String> pattenWords;


    public Node() {
        childNodes = new HashMap<>();
        this.pattenWords = new ArrayList<>();
    }

    public Node(boolean root) {
        this();
        this.root = root;
    }

    public Node insert(Character character) {
        Node node = this.childNodes.get(character);
        if (node == null) {
            node = new Node();
            childNodes.put(character, node);
        }
        return node;
    }

    public void addPattenString(String word){
        this.pattenWords.add(word);
    }

    public void addPattenString(Collection<String> keywords) {
        pattenWords.addAll(keywords);
    }


    public Node find(Character character) {
        return this.childNodes.get(character);
    }

    /**
     * AC 查找
     * @param transition
     * @return
     */
    public Node nextState(Character transition) {
        Node state = this.find(transition);
        if (state != null) {
            return state;
        }

        if (this.root) {
            return this;
        }

        return this.failure.nextState(transition);
    }


    /**
     * BFS + DFS
     *
     * @param transition
     * @return
     */
    public Node findNext(Character transition) {
        Node state = this.find(transition);
        if (state != null) {
            return state;
        }

        if (this.root) {
            return this;
        }

        return null;
    }

    public void setFailure(Node failure) {
        this.failure = failure;
    }

    public Node getFailure() {
        return failure;
    }

    public Set<Character> getCharacters() {
        return childNodes.keySet();
    }

    public Collection<Node> childNodes() {
        return this.childNodes.values();
    }


    public Collection<String> patternWords() {
        return this.pattenWords == null ? Collections.<String>emptyList() : this.pattenWords;
    }

}
