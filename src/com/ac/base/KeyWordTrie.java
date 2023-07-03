package com.ac.base;

import com.ac.test1.PattenString;

import java.util.*;

/**
 * @author zhai
 * @date 2022/4/28 10:35 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class KeyWordTrie {

    /**
     * 规则组根节点
     */
    private Node root;
    /**
     * 是否创建了失败回溯
     */
    private Boolean failureStatesConstructed = false;

    public KeyWordTrie(Boolean failureStatesConstructed) {
        this.root = new Node(true);
        this.failureStatesConstructed = failureStatesConstructed;
    }

    /**
     * 添加关键词
     *
     * @param element
     */
    public void addElement(String element) {

        if (element == null || element.length() == 0) {
            return;
        }

        Node currNode = this.root;

        for (Character word : element.toCharArray()) {
            currNode = currNode.insert(word);
        }
        currNode.addPattenString(element);
    }


    /**
     * 创建失败回溯关系
     */
    public void constructFailureStates() {
        Queue<Node> queue = new LinkedList<>();

        //首先从把root的子节点的fail node全设为root
        //然后将root的所有子节点加到queue里面
        for (Node depthOneState : this.root.childNodes()) {
            depthOneState.setFailure(this.root);
            queue.add(depthOneState);
        }
        this.failureStatesConstructed = true;

        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();
            for (Character transition : parentNode.getCharacters()) {
                Node childNode = parentNode.find(transition);
                queue.add(childNode);
                Node failNode = parentNode.getFailure().nextState(transition);
                childNode.setFailure(failNode);

                //每个节点处的PattenString要加上它的fail node处的PattenString
                //因为能匹配到这个位置的话，那么fail node处的PattenString一定是匹配的pattern
                childNode.addPattenString(failNode.patternWords());
            }
        }
    }


    /**
     * 匹配关键词
     * 模糊匹配
     *
     * @param matchText
     */
    public List<PattenString> fuzzyMatch(String matchText) {

        Node currentState = this.root;
        List<PattenString> collectedPattenStrings = new ArrayList<>();
        for (int position = 0; position < matchText.length(); position++) {
            Character character = matchText.charAt(position);
            currentState = currentState.nextState(character);
            Collection<String> pattenStrings = currentState.patternWords();
            if (pattenStrings == null || pattenStrings.isEmpty()) {
                continue;
            }
            for (String pattenWord : pattenStrings) {
                collectedPattenStrings.add(new PattenString(position - pattenWord.length() + 1, position, pattenWord));
            }
        }
        return collectedPattenStrings;
    }

    /**
     * 精确匹配
     *
     * @param matchText
     * @return
     */
    public List<PattenString> accurateMatch(String matchText) {
        Node currentState = this.root;
        // 循环需要匹配的字符串
        List<PattenString> collectedPattenStrings = new ArrayList<>();
        for (int position = 0; position < matchText.length(); position++) {
            Character word = matchText.charAt(position);
            currentState = currentState.findNext(word);
            if (currentState == null && position <= matchText.length() - 1) {
                return collectedPattenStrings;
            }
            if (position == matchText.length() - 1) {
                Collection<Node> nodes = currentState.childNodes();
                if (!nodes.isEmpty()) {
                    return collectedPattenStrings;
                }
            }
        }
        collectedPattenStrings.add(new PattenString(0, matchText.length(), matchText));
        return collectedPattenStrings;
    }

}
